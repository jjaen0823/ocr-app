package com.hanwha.ocrapp.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanwha.ocrapp.adapter.in.web.dto.response.NaverOCRResponse;
import com.hanwha.ocrapp.adapter.out.feign.NaverOCRClient;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.naver.NaverOCRImage;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.naver.NaverOCRImageFormat;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.naver.NaverOCRMultipartFormImage;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.naver.NaverOCRRequest;
import com.hanwha.ocrapp.adapter.out.feign.dto.response.naver.NaverOCRIDCardResponse;
import com.hanwha.ocrapp.application.port.in.NaverOCRUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class NaverOCRService implements NaverOCRUseCase {
    private final ObjectMapper objectMapper;
    private final NaverOCRClient naverOCRClient;

    @Override
    public NaverOCRResponse getNaverOCRResult(MultipartFile multipartFile) {
        String valueAsString = null;
        try {
            valueAsString = objectMapper.writeValueAsString(getImageData(UUID.randomUUID().toString(), getFileExtension(multipartFile)));
        } catch (JsonProcessingException e) {
            log.error("Json 파싱 에러");
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 처리 에러");
        }

        ResponseEntity<NaverOCRIDCardResponse> response = naverOCRClient.getIDCardDataUsingMultipartForm(multipartFile, valueAsString);

        // feign client response to dto
        if ((response.getStatusCode().value() == 200) && (response.getBody() != null)) {
            NaverOCRIDCardResponse.Image.IDCard.Result.IC idCardInfo = response.getBody().getImages().get(0).getIdCard().getResult().getIc();
            NaverOCRIDCardResponse.Image.IDCard.Result.Address addressInfo = idCardInfo.getAddress().get(0);
            NaverOCRIDCardResponse.Image.IDCard.Result.IC.Name nameInfo = idCardInfo.getName().get(0);
            NaverOCRIDCardResponse.Image.IDCard.Result.PersonalNum personalNumInfo = idCardInfo.getPersonalNum().get(0);

            log.info("신분증 OCR 성공");
            return NaverOCRResponse.builder()
                    .customerName(nameInfo.getFormatted().getValue())
                    .customerAddress(addressInfo.getFormatted().getValue())
                    .customerPersonalNum(personalNumInfo.getFormatted().getValue())
                    .build();
        }

        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "신분증 사진을 다시 확인해 주세요.");
    }

    private NaverOCRRequest getImageData(String imageName, String imageFormat) {
        NaverOCRImage hanwhalifeImage = new NaverOCRMultipartFormImage(imageName, imageFormat);
        return new NaverOCRRequest(UUID.randomUUID().toString(), System.currentTimeMillis(), List.of(hanwhalifeImage));
    }

    // TODO FileUtils
    private String getFileExtension(MultipartFile multipartFile) {
        String filenameExtension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
        NaverOCRImageFormat imageFormat;
        try {
            imageFormat = NaverOCRImageFormat.valueOf(filenameExtension);
        } catch (IllegalArgumentException exception) {
            log.error("파일 확장자 에러");
            // TODO Http Status Code 처리 방법
            // https://atoz-developer.tistory.com/121
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "지원하지 않는 파일 확장자입니다. " +
                    "\"jpg\", \"jpeg\", \"png\" 이미지, \"pdf\",\"tiff\" 단일 페이지 형식을 지원합니다.");
        }
        return imageFormat.getValue();
    }
}

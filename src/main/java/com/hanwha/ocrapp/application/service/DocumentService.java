package com.hanwha.ocrapp.application.service;

import com.hanwha.ocrapp.adapter.in.web.dto.request.FamilyDocumentInfoRequest;
import com.hanwha.ocrapp.adapter.in.web.dto.response.FamiliesInfoResponse;
import com.hanwha.ocrapp.adapter.out.feign.HyphenDocumentClient;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen.HyphenFamilyDocumentRequest;
import com.hanwha.ocrapp.adapter.out.feign.dto.response.hyphen.HyphenFamilyDocumentResponse;
import com.hanwha.ocrapp.application.port.in.DocumentUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentService implements DocumentUseCase {

    private final HyphenDocumentClient hyphenDocumentClient;
    @Override
    public FamiliesInfoResponse getFamiliesInfoList(FamilyDocumentInfoRequest request) {
        HyphenFamilyDocumentRequest payload = HyphenFamilyDocumentRequest.builder()
                .mobileNo(request.getCustomerPhoneNum().replace("-", ""))
                .name(request.getCustomerName())
                .rrn1(request.getCustomerPersonalNum().substring(0,6))
                .rrn2(request.getCustomerPersonalNum().substring(7,14))
                .fthrNm(request.getFatherName())
                .build();

        // Request
        // TODO 요청에서 에러가 발생했을 경우 - 고객정보를 잘못 요청하는 경우 feignclient에러 발생 !! -> ErrorDecoder 필요
        ResponseEntity<HyphenFamilyDocumentResponse> response = hyphenDocumentClient.getFamilyDocumentData(payload);

        // feign client response to dto
        if ((response.getStatusCode().value() == 200) && (response.getBody() != null)) {
            List<HyphenFamilyDocumentResponse.Data.FamilyData> familyDataList = response.getBody().getData().getList();
            List<FamiliesInfoResponse.FamilyInfo> familyInfoList = familyDataList.stream()
                    .map(familyData -> FamiliesInfoResponse.FamilyInfo.builder()
                            .div(familyData.getDiv())
                            .name(familyData.getName())
                            .sex(familyData.getSex())
                            .personalNum(familyData.getRegNo())
                            .build())
                    .collect(Collectors.toList());

            log.info("가족관계증명서 인증 성공");
            return FamiliesInfoResponse.builder()
                    .familyInfo(familyInfoList)
                    .build();
        }
        else {
            log.error("가족관계증명서 인증 실패");
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "가족관계증명 인증에 실패하였습니다..");
        }

    }
}

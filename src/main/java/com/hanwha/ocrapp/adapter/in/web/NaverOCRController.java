package com.hanwha.ocrapp.adapter.in.web;

import com.hanwha.ocrapp.adapter.in.web.dto.response.NaverOCRResponse;
import com.hanwha.ocrapp.application.port.in.NaverOCRUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/id-cards")
@RequiredArgsConstructor
public class NaverOCRController {
    private final NaverOCRUseCase naverOCRUseCase;

    @PostMapping(value = "/files")
    public NaverOCRResponse handleFileUpload(@RequestPart(value = "file", required = false) MultipartFile multipartFile) {
        if (multipartFile == null || multipartFile.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "신분증 사진을 다시 확인해 주세요.");
        }

        return naverOCRUseCase.getNaverOCRResult(multipartFile);
    }

}



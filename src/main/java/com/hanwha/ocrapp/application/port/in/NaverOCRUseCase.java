package com.hanwha.ocrapp.application.port.in;

import com.hanwha.ocrapp.adapter.in.web.dto.response.NaverOCRResponse;
import org.springframework.web.multipart.MultipartFile;

public interface NaverOCRUseCase {

    NaverOCRResponse getNaverOCRResult(MultipartFile multipartFile);
}

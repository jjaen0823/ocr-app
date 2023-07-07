package com.hanwha.ocrapp.adapter.out.feign.dto.request.naver;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NaverOCRImageFormat {
    JPG("jpg"),
    JPEG("jpeg"),
    PNG("png");

    private final String value;
}

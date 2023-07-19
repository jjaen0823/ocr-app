package com.hanwha.ocrapp.adapter.out.feign.dto.request.naver;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum NaverOCRImageFormat {
    jpg("jpg"),
    jpeg("jpeg"),
    png("png"),
    tiff("tiff"),
    pdf("pdf");

    private final String value;
}

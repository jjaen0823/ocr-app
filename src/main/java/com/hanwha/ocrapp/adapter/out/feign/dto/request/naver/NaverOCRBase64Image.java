package com.hanwha.ocrapp.adapter.out.feign.dto.request.naver;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NaverOCRBase64Image extends NaverOCRImage {

    @JsonProperty("data")
    String data;  // img.decode('utf-8')

    public NaverOCRBase64Image(String name, String format, String data) {
        super(name, format);
        this.data = data;
    }
}

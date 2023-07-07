package com.hanwha.ocrapp.adapter.out.feign.dto.request.naver;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class NaverOCRImage {
    @JsonProperty("name")
    String name;
    @JsonProperty("format")
    String format;  // jpg, jpeg, png
}

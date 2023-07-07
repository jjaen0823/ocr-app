package com.hanwha.ocrapp.adapter.out.feign.dto.request.naver;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static com.hanwha.ocrapp.adapter.out.feign.constants.FeignConstants.NAVER_OCR_VERSION;

public class NaverOCRRequest {
    @JsonProperty("version")
    private String version = NAVER_OCR_VERSION;
    @JsonProperty("requestId")
    private String requestId; // uuid
    @JsonProperty("timestamp")
    private long timestamp; // 현재 시간값

    @JsonProperty("images")
    private List<NaverOCRImage> images;

    public NaverOCRRequest(String requestId, long timestamp, List<NaverOCRImage> images) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.images = images;
    }

}

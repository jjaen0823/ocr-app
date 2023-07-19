package com.hanwha.ocrapp.adapter.in.web.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class NaverOCRResponse {
    private String customerName;
    private String customerPersonalNum;
    private String customerAddress;
}

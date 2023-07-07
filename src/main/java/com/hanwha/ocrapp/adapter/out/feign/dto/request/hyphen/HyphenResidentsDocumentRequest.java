package com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class HyphenResidentsDocumentRequest {
    private String authMethod;
    private String loginOrgCd;
    private String mobileNo;
    private String sido;
    private long sigg;
    private String cusGb;
    private String userName;
    private String bizNo;
}

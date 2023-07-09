package com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HyphenResidentsDocumentRequest {
    @JsonProperty("authMethod")
    private String authMethod;
    @JsonProperty("loginOrgCd")
    private String loginOrgCd;
    @JsonProperty("mobileNo")
    private String mobileNo;
    @JsonProperty("sido")
    private String sido;
    @JsonProperty("sigg")
    private String sigg;
    @JsonProperty("cusGb")
    private String cusGb;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("bizNo")
    private String bizNo;
}

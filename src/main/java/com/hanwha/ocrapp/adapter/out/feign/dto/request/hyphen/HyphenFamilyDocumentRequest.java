package com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class HyphenFamilyDocumentRequest {
    private String loginMethod;
    private String loginOrgCd;
    private String mobileNo;
    private String name;
    private long rrn1;
    private String rrn2;
    private String fthrNm;
    @JsonProperty("req_fmyrltCd")
    private long req_fmyrltCd;
    @JsonProperty("req_name")
    private String req_name;
    @JsonProperty("req_rrn1")
    private String req_rrn1;
    @JsonProperty("req_rrn2")
    private long req_rrn2;
    private String certCerFg;
    private String rrnPaYn;
    @JsonProperty("issrsnCd")
    private long issrsnCd;
}

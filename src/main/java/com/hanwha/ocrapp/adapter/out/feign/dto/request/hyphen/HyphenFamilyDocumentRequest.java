package com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


public class HyphenFamilyDocumentRequest {
    @JsonProperty("loginMethod")
    private String loginMethod;
    @JsonProperty("loginOrgCd")
    private String loginOrgCd;
    @JsonProperty("mobileNo")
    private String mobileNo;
    @JsonProperty("name")
    private String name;
    @JsonProperty("rrn1")
    private String rrn1;
    @JsonProperty("rrn2")
    private String rrn2;
    @JsonProperty("fthrNm")
    private String fthrNm;
    @JsonProperty("req_fmyrltCd")
    private String req_fmyrltCd;
    @JsonProperty("req_name")
    private String req_name;
    @JsonProperty("req_rrn1")
    private String req_rrn1;
    @JsonProperty("req_rrn2")
    private String req_rrn2;
    @JsonProperty("certCerFg")
    private String certCerFg;
    @JsonProperty("rrnPaYn")
    private String rrnPaYn;
    @JsonProperty("issrsnCd")
    private String issrsnCd;

    @Builder
    public HyphenFamilyDocumentRequest(String mobileNo, String name, String rrn1, String rrn2, String fthrNm) {
        this.loginMethod = LoginMethod.EASY.getValue();
        this.loginOrgCd = LoginOrganization.KAKAO.getValue();
        this.mobileNo = mobileNo;
        this.name = name;
        this.rrn1 = rrn1;
        this.rrn2 = rrn2;
        this.fthrNm = fthrNm;
        this.req_fmyrltCd = "01";
        this.req_name = name;
        this.req_rrn1 = rrn1;
        this.req_rrn2 = rrn2;
        this.certCerFg = "4";
        this.rrnPaYn = "3";
        this.issrsnCd = "02";
    }
}

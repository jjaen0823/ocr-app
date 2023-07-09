package com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

public class HyphenResidentsDocumentRequest {
    @JsonProperty("authMethod")
    private String loginMethod;
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
    private String name;
    @JsonProperty("bizNo")
    private String personalNum;

    @Builder
    public HyphenResidentsDocumentRequest(String mobileNo, String sido, String sigg, String name, String personalNum) {
        this.loginMethod = LoginMethod.EASY.getValue();
        this.loginOrgCd = LoginOrganization.KAKAO.getValue();
        this.mobileNo = mobileNo;
        this.sido = sido;  // 서울특별시
        this.sigg = sigg;  // 00구
        this.cusGb = "01";  // 신청자 구분
        this.name = name;
        this.personalNum = personalNum;
    }
}

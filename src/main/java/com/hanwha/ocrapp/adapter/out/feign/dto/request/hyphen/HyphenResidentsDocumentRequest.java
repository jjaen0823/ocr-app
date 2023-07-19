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
    @JsonProperty("req1Opt6")
    private String req1Opt6;  // 교부대상자외 세대주와 다른 세대원들의 이름
    @JsonProperty("req1Opt7")
    private String req1Opt7;  // 주민등록번호 뒷자리

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
        this.req1Opt6 = "01";  // 포함
        this.req1Opt7 = "01";  // 포함
    }
}

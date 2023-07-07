package com.hanwha.ocrapp.adapter.out.feign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen.HyphenFamilyDocumentRequest;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen.LoginMethod;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen.LoginOrganization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HyphenDocumentClientTest {
    @Value("${ocr.hyphen.test.mobileNo}")
    private String MOBILE_NO;
    @Value("${ocr.hyphen.test.name}")
    private String NAME;
    @Value("${ocr.hyphen.test.mobileNo}")
    private String mobileNo;
    @Value("${ocr.hyphen.test.mobileNo}")
    private String mobileNo;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private HyphenDocumentClient hyphenDocumentClient;

    @Test
    public void getFamilyDocumentTest() throws JsonProcessingException {
        // make payload
        HyphenFamilyDocumentRequest request = new HyphenFamilyDocumentRequest(
            LoginMethod.EASY.getValue(),
            LoginOrganization.KAKAO.getValue(),
            MOBILE_NO,
            NAME,
            ,
        );


        // Request


        // Validation


        // Response
    }

    @Test
    public void getResidentsDocumentTest() {

    }

}
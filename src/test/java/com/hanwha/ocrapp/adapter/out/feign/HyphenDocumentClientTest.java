package com.hanwha.ocrapp.adapter.out.feign;

import com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen.HyphenFamilyDocumentRequest;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen.HyphenResidentsDocumentRequest;
import com.hanwha.ocrapp.adapter.out.feign.dto.response.hyphen.HyphenDocumentSimpleResponse;
import com.hanwha.ocrapp.adapter.out.feign.dto.response.hyphen.HyphenFamilyDocumentBasicResponse;
import com.hanwha.ocrapp.adapter.out.feign.dto.response.hyphen.HyphenFamilyDocumentResponse;
import com.hanwha.ocrapp.adapter.out.feign.dto.response.hyphen.HyphenResidentsDocumentResponse;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@Slf4j
@SpringBootTest
class HyphenDocumentClientTest {
    // TODO 가족관계증명서 사용자 입력으로 받아야 하는 값
    /**
     * < 가족관계기본증명서, 가족관계증명서 >
     * MOBILE_NO : 핸드폰 번호
     * NAME : 본인 이름
     * RRN1 : 주민등록번호 앞자리 (6자리)
     * RRN2 : 주민등혹번호 뒷자리 (7자리)
     * FATHER_NAME : 부 이름 || MOTHER_NAME : 모 이름
     *
     * < 주민등록등본 >
     * MOBILE_NO : 핸드폰 번호
     * NAME : 본인 이름
     * RRN1 + RRN2 : 주민등록번호
     * sido: 시
     * sigg: 구
     */
    @Value("${ocr.hyphen.test.mobileNo}")
    private String MOBILE_NO;
    @Value("${ocr.hyphen.test.name}")
    private String NAME;
    @Value("${ocr.hyphen.test.rrn1}")
    private String RRN1;
    @Value("${ocr.hyphen.test.rrn2}")
    private String RRN2;
    @Value("${ocr.hyphen.test.fthrNm}")
    private String FATHER_NAME;

    @Autowired
    private HyphenDocumentClient hyphenDocumentClient;

    @Test
    public void getFamilyDocumentBasicTest() {
        // make payload
        // TODO 사용자 입력
        HyphenFamilyDocumentRequest payload = HyphenFamilyDocumentRequest.builder()
            .mobileNo(MOBILE_NO).name(NAME).rrn1(RRN1).rrn2(RRN2).fthrNm(FATHER_NAME)
            .build();

        // Request
        ResponseEntity<HyphenFamilyDocumentBasicResponse> response = hyphenDocumentClient.getFamilyDocumentDataBasic(payload);

        // Validation
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().toString()).contains("name=최재은");

        // Response
        log.info(response.getBody().toString());
    }

    @Test
    public void getFamilyDocumentTest() {
        // make payload
        // TODO 사용자 입력
        HyphenFamilyDocumentRequest payload = HyphenFamilyDocumentRequest.builder()
            .mobileNo(MOBILE_NO).name(NAME).rrn1(RRN1).rrn2(RRN2).fthrNm(FATHER_NAME)
            .build();

        // Request
        ResponseEntity<HyphenFamilyDocumentResponse> response = hyphenDocumentClient.getFamilyDocumentData(payload);

        // Validation
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().toString()).contains("name=최재은");

        // Response
        log.info(response.getBody().toString());
    }

    @Test
    public void getFamilyDocumentTest_fail() {
        // make payload
        // TODO 사용자 입력
        HyphenFamilyDocumentRequest payload = HyphenFamilyDocumentRequest.builder()
            .mobileNo(MOBILE_NO).name(NAME).rrn1(RRN1).rrn2(RRN2).fthrNm("최재은")
            .build();

        // Request
        ResponseEntity<HyphenDocumentSimpleResponse> response = hyphenDocumentClient.getFamilyDocumentDataSimple(payload);

        // Validation
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().toString()).contains("errYn=Y");

        // Response
        log.info(response.toString());
        log.info(response.getBody().toString());
    }

    @Test
    public void getResidentsDocumentTest() {
        // make payload
        // TODO 사용자 입력
        HyphenResidentsDocumentRequest payload = HyphenResidentsDocumentRequest.builder()
                .mobileNo(MOBILE_NO)
                .name(NAME)
                .personalNum(RRN1 + RRN2)
                .sido("서울특별시")
                .sigg("동작구")
                .build();

        // Request
        ResponseEntity<HyphenResidentsDocumentResponse> response = hyphenDocumentClient.getResidentsDocumentData(payload);

        // Validation
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().toString()).contains("최재은");
        Assertions.assertThat(response.getBody().toString()).contains("990823");

        // Response
        log.info(response.getBody().toString());
    }

}
package com.hanwha.ocrapp.adapter.out.feign;

import com.hanwha.ocrapp.adapter.out.feign.configuration.FeignSupportConfig;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen.HyphenFamilyDocumentRequest;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen.HyphenResidentsDocumentRequest;
import com.hanwha.ocrapp.adapter.out.feign.dto.response.hyphen.HyphenFamilyDocumentResponse;
import com.hanwha.ocrapp.adapter.out.feign.dto.response.hyphen.HyphenResidentsDocumentResponse;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.hanwha.ocrapp.adapter.out.feign.constants.FeignConstants.HYPHEN_DOCUMENT;

@FeignClient(
        value = HYPHEN_DOCUMENT,
        url = "${ocr.hyphen.url}",
        configuration = { FeignSupportConfig.class }
)
public interface HyphenDocumentClient {

    @RequestMapping(
            method = { RequestMethod.POST },
            value = { "/in0021000228" },
            consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    ResponseEntity<HyphenFamilyDocumentResponse> getFamilyDocumentData(@RequestBody HyphenFamilyDocumentRequest payload);

    @RequestMapping(
            method = { RequestMethod.POST },
            value = { "/in0021000228" },
            consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    ResponseEntity<HyphenResidentsDocumentResponse> getResidentsDocumentData(@RequestBody HyphenResidentsDocumentRequest payload);

    class HyphenFamilyDocumentConfiguration {
        @Value("${ocr.hyphen.user-id}")
        String USER_ID;
        @Value("${ocr.hyphen.key}")
        String SECRET_KEY;
//        @Bean
//        private ErrorDecoder errorDecoder() {
//            return new HyphenFamilyDocumentErrorDecoder();
//        }

        @Bean
        private RequestInterceptor requestInterceptor() {
            return requestTemplate -> {
                requestTemplate.header("user-id", USER_ID);
                requestTemplate.header("Hkey", SECRET_KEY);
            };
        }
    }
}

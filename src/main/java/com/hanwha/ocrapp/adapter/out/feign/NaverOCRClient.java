package com.hanwha.ocrapp.adapter.out.feign;

import com.hanwha.ocrapp.adapter.out.feign.configuration.FeignSupportConfig;
import com.hanwha.ocrapp.adapter.out.feign.configuration.NaverOCRErrorDecoder;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.naver.NaverOCRRequest;
import com.hanwha.ocrapp.adapter.out.feign.dto.response.naver.NaverOCRIDCardResponse;
import com.hanwha.ocrapp.adapter.out.feign.dto.response.naver.NaverOCRIDCardResponseSimple;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import static com.hanwha.ocrapp.adapter.out.feign.constants.FeignConstants.NAVER_OCR;


@FeignClient(
    value = NAVER_OCR,
    url = "${ocr.naver.url}",
    configuration = { FeignSupportConfig.class, NaverOCRClient.NaverOCRClientConfiguration.class }
)
public interface NaverOCRClient {

    /** NAVER OCR reference
     *
     * < header >
     * - application/json : 요청에 JSON 본문 사용. Base64로 인코딩된 image.data 지원.
     * - multipart/form-data : 요청에 멀티파트 본문 사용. 스트리밍으로 전송된 이미지 파일 지원.
     */

    @RequestMapping(
        method = { RequestMethod.POST },
        value = { "/custom/v1/3713/22a424701c090378c9e9a702a1f71465113751bb0a740a90abba1dbf708ae11b/document/id-card" },
        consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    ResponseEntity<NaverOCRIDCardResponseSimple> getIDCardDataUsingBase64(@RequestBody NaverOCRRequest payload);

    @RequestMapping(
            method = { RequestMethod.POST },
            value = { "/custom/v1/3713/22a424701c090378c9e9a702a1f71465113751bb0a740a90abba1dbf708ae11b/document/id-card" },
            consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }
    )
    ResponseEntity<NaverOCRIDCardResponseSimple> getIDCardDataUsingMultipartFormSimple(
            @RequestPart(value = "file") MultipartFile file,
            @RequestPart(value = "message") String message
    );

    @RequestMapping(
            method = { RequestMethod.POST },
            value = { "/custom/v1/3713/22a424701c090378c9e9a702a1f71465113751bb0a740a90abba1dbf708ae11b/document/id-card" },
            consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }
    )
    ResponseEntity<NaverOCRIDCardResponse> getIDCardDataUsingMultipartForm(
            @RequestPart(value = "file") MultipartFile file,
            @RequestPart(value = "message") String message
    );

    class NaverOCRClientConfiguration {
        @Value("${ocr.naver.key}")
        String SECRET_KEY;
        @Bean
        ErrorDecoder errorDecoder() {
            return new NaverOCRErrorDecoder();
        }

        @Bean
        RequestInterceptor requestInterceptor() {
            return requestTemplate -> {
                requestTemplate.header("x-ocr-secret", SECRET_KEY);
            };
        }
    }
}

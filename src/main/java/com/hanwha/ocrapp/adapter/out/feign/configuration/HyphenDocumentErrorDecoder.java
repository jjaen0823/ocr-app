package com.hanwha.ocrapp.adapter.out.feign.configuration;

import feign.Response;
import feign.codec.ErrorDecoder;

public class HyphenDocumentErrorDecoder implements ErrorDecoder {

    /** NAVER OCR API errors
     * - 400	요청 매개변수가 유효하지 않거나 제약 조건에 문제가 있음.
     * - 401	잘못된 API secret key (X-OCR-API-KEY)
     * - 500	내부 서버 오류
     * <p>
     * cc.
     * <p>
     * Response Body
     * {
     *   // TODO Response parsing, Error Code 에 따른 예외처리
     *   "code": "Error Code",  // TODO
     *   "message": "error details message.",  // TODO
     *   "path": "request API path",
     *   "timestamp": 1570776853475
     * }
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        switch(response.status()) {
            case 400:
                try {
                    // code block
                    System.out.println(response.body());
                } catch (Exception e) {
                    System.out.println("400 \n" + e);
                }
                break;
            case 401:
                try {
                    // code block
                    System.out.println(response.body());
                } catch (Exception e) {
                    System.out.println("401 \n" + e);
                }
                break;
            case 500:
                try {
                    // code block
                    System.out.println(response.body());
                } catch (Exception e) {
                    System.out.println("500 \n" + e);
                }
                break;
            default:
                // code block
                System.out.println(response.body());
                System.out.println("else");
        }
        return null;
    }
}

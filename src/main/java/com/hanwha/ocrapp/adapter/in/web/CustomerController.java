package com.hanwha.ocrapp.adapter.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    @PostMapping(value = "/customers")
    public String saveCustomerInfo() {
        // TODO 정보 확인 -> 등록 버튼 -> 고객 정보 등록 (DB 저장)
        return "";
    }
}

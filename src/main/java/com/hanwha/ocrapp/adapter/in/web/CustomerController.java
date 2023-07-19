package com.hanwha.ocrapp.adapter.in.web;

import com.hanwha.ocrapp.adapter.in.web.dto.request.CustomerAndFamilyInfoRequest;
import com.hanwha.ocrapp.adapter.in.web.dto.request.CustomerInfoRequest;
import com.hanwha.ocrapp.application.port.in.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    /**
     * 본인 등록
     */
    @PostMapping(value = "/customers")
    public String saveCustomerInfo(@RequestBody CustomerInfoRequest request) {
        // TODO 정보 확인 -> 등록 버튼 -> 고객 정보 등록 (DB 저장)
        customerUseCase.registerCustomerInfo(request);

        return "SUCCESS";
    }

    /**
     * 본인 및 가족 등록
     */
    @PostMapping(value = "/customers/families")
    public String saveCustomerInfo(@RequestBody CustomerAndFamilyInfoRequest request) {
        // TODO 정보 확인 -> 등록 버튼 -> 고객 정보 등록 (DB 저장)
        customerUseCase.registerCustomerInfo(request);

        return "SUCCESS";
    }


}

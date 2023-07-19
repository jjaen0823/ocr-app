package com.hanwha.ocrapp.adapter.in.web.dto.request;


import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CustomerInfoRequest {
    @NotBlank(message = "고객 이름을 확인해 주세요.")
    private String customerName;
    @NotBlank(message = "고객 주민등록번호를 확인해 주세요.")
    private String customerPersonalNum;
    @NotBlank(message = "고객 주소을 확인해 주세요.")
    private String customerAddress;
}

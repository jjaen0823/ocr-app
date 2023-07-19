package com.hanwha.ocrapp.adapter.in.web.dto.request;


import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class FamilyInfoRequest {
    private String familyName;
    private String familyPersonalNum;
//    private String familyAddress;  // == customerPersonalNum
    private String div;
    private String sex;
}

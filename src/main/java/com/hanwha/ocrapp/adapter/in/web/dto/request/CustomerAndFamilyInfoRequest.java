package com.hanwha.ocrapp.adapter.in.web.dto.request;


import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class CustomerAndFamilyInfoRequest {
    private CustomerInfoRequest customerInfo;
    private List<FamilyInfoRequest> familyInfoList;
}

package com.hanwha.ocrapp.application.port.out;

import com.hanwha.ocrapp.adapter.in.web.dto.request.CustomerInfoRequest;
import com.hanwha.ocrapp.adapter.in.web.dto.request.FamilyInfoRequest;

import java.util.List;

public interface CustomerPort {

    void saveCustomerAndFamily(CustomerInfoRequest customerInfo, List<FamilyInfoRequest> familyInfoList);
}

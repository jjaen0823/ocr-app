package com.hanwha.ocrapp.application.port.in;

import com.hanwha.ocrapp.adapter.in.web.dto.request.CustomerAndFamilyInfoRequest;
import com.hanwha.ocrapp.adapter.in.web.dto.request.CustomerInfoRequest;

public interface CustomerUseCase {
    void registerCustomerInfo(CustomerInfoRequest request);
    void registerCustomerInfo(CustomerAndFamilyInfoRequest request);
}

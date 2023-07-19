package com.hanwha.ocrapp.application.service;

import com.hanwha.ocrapp.adapter.in.web.dto.request.CustomerAndFamilyInfoRequest;
import com.hanwha.ocrapp.adapter.in.web.dto.request.CustomerInfoRequest;
import com.hanwha.ocrapp.adapter.in.web.dto.request.FamilyInfoRequest;
import com.hanwha.ocrapp.application.port.in.CustomerUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerService implements CustomerUseCase {

    @Override
    public void registerCustomerInfo(CustomerInfoRequest customerInfoRequest) {
        // TODO 본인 등록
    }

    @Override
    public void registerCustomerInfo(CustomerAndFamilyInfoRequest request) {
        // TODO 본인 및 가족 등록
        CustomerInfoRequest customerInfo = request.getCustomerInfo();
        List<FamilyInfoRequest> familyInfoList = request.getFamilyInfoList();

        log.info(familyInfoList.toString());
    }
}

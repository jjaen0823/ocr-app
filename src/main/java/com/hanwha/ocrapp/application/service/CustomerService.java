package com.hanwha.ocrapp.application.service;

import com.hanwha.ocrapp.adapter.in.web.dto.request.CustomerAndFamilyInfoRequest;
import com.hanwha.ocrapp.adapter.in.web.dto.request.CustomerInfoRequest;
import com.hanwha.ocrapp.adapter.in.web.dto.request.FamilyInfoRequest;
import com.hanwha.ocrapp.application.port.in.CustomerUseCase;
import com.hanwha.ocrapp.application.port.out.CustomerPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerUseCase {
    private final CustomerPort customerPort;

    @Transactional
    @Override
    public void registerCustomerInfo(CustomerInfoRequest customerInfoRequest) {
        // TODO 본인 등록
    }

    @Transactional
    @Override
    public void registerCustomerInfo(CustomerAndFamilyInfoRequest request) {
        // 본인 및 가족 등록
        customerPort.saveCustomerAndFamily(request.getCustomerInfo(), request.getFamilyInfoList());
    }
}

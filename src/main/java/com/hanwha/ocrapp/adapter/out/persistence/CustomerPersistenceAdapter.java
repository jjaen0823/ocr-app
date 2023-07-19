package com.hanwha.ocrapp.adapter.out.persistence;

import com.hanwha.ocrapp.adapter.in.web.dto.request.CustomerInfoRequest;
import com.hanwha.ocrapp.adapter.in.web.dto.request.FamilyInfoRequest;
import com.hanwha.ocrapp.adapter.out.persistence.entity.CustomerEntity;
import com.hanwha.ocrapp.adapter.out.persistence.repository.CustomerJpaRepository;
import com.hanwha.ocrapp.application.port.out.CustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CustomerPersistenceAdapter implements CustomerPort {
    private final CustomerJpaRepository customerJpaRepository;

    @Override
    public void saveCustomerAndFamily(CustomerInfoRequest customerInfo, List<FamilyInfoRequest> familyInfoList) {
        // 본인 등록
        customerJpaRepository.save(
                CustomerEntity.builder()
                        .name(customerInfo.getCustomerName())
                        .personalNum(customerInfo.getCustomerPersonalNum())
                        .address(customerInfo.getCustomerAddress())
                        .mobileNo(customerInfo.getCustomerPhoneNum())
                        .build()
        );

        // 가족 등록
        customerJpaRepository.saveAll(familyInfoList.stream().map(familyData ->
                CustomerEntity.builder()
                        .name(familyData.getFamilyName())
                        .personalNum(familyData.getFamilyPersonalNum())
                        .address(customerInfo.getCustomerAddress())
                        .build()
        ).collect(Collectors.toList()));
    }
}

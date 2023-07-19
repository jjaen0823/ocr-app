package com.hanwha.ocrapp.adapter.out.persistence.repository;

import com.hanwha.ocrapp.adapter.out.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
}

package com.hanwha.ocrapp.adapter.out.persistence.entity;


import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Table(name = "customer")
@Entity
public class CustomerEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 15, nullable = false)
    private String personalNum;  // 000000-0000000
    @Column(nullable = false)
    private String address;
    @Column(length = 20)
    private String mobileNo;

    @Builder
    public CustomerEntity(String name, String personalNum, String address, String mobileNo) {
        this.name = name;
        this.personalNum = personalNum;
        this.address = address;
        this.mobileNo = mobileNo;
    }
}

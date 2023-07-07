package com.hanwha.ocrapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OcrAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OcrAppApplication.class, args);
    }

}

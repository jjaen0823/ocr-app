package com.hanwha.ocrapp.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@AutoConfigureMockMvc
@SpringBootTest
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPostRequestToCustomerInfo_Valid() throws Exception {
        String customerInfo = "{\"customerName\": \"최재은\", \"customerPersonalNum\": \"990823-2229917\", " +
                "\"customerAddress\": \"서울특별시 국사봉길 119-14 402호\"}";
        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, StandardCharsets.UTF_8);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/customers")
                        .content(customerInfo)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
    }
    @Test
    public void whenPostRequestToCustomerInfo_Invalid() throws Exception {
        String customerInfo = "{\"customerName\": \"\", \"customerPersonalNum\": \"990823-2229917\", " +
                "\"customerAddress\": \"서울특별시 국사봉길 119-14 402호\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/customers")
                        .content(customerInfo)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
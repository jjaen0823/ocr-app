package com.hanwha.ocrapp.adapter.out.feign.dto.response.naver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor
class NaverOCRIDCardResponseTest {

    private final ObjectMapper objectMapper;

    @Test
    void printConvertedJsonStrTest() throws JsonProcessingException {
        String jsonStr = objectMapper.writeValueAsString(
                new NaverOCRIDCardResponse(
                        List.of(new NaverOCRIDCardResponse.Image(
                                new NaverOCRIDCardResponse.Image.IDCard(
                                        new NaverOCRIDCardResponse.Image.IDCard.Meta(""),
                                        new NaverOCRIDCardResponse.Image.IDCard.Result(
                                                "", true,
                                                List.of(new NaverOCRIDCardResponse.BoundingPoly(
                                                        List.of(new NaverOCRIDCardResponse.Vertex(0.0, 0.0))
                                                )),
                                                new NaverOCRIDCardResponse.Image.IDCard.Result.IC())
                                ),
                                "", "", "", "",
                                new NaverOCRIDCardResponse.ValidationResult("")
                        )),
                        "", 0L, "V2"
                ));
        log.info(jsonStr);

        Assertions.assertThat(jsonStr)
                .contains("idCard")
                .contains("isConfident")
                .contains("validationResult")
                .contains("idtype")
                .contains("uid");
    }
}
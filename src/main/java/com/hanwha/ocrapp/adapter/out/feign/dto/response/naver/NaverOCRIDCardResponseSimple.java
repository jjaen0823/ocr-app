package com.hanwha.ocrapp.adapter.out.feign.dto.response.naver;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.ToString;

import java.util.List;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@ToString
public class NaverOCRIDCardResponseSimple {
    @JsonProperty("version")
    private String version;
    @JsonProperty("timestamp")
    private long timestamp;
    @JsonProperty("requestId")
    private String requestId;

    @JsonRawValue
    @JsonProperty("images")
    private List<Object> images;
}

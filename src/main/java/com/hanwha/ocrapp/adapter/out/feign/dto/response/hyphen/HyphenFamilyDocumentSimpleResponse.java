package com.hanwha.ocrapp.adapter.out.feign.dto.response.hyphen;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class HyphenFamilyDocumentSimpleResponse {
    @JsonRawValue
    @JsonProperty("common")
    private Object common;
    @JsonRawValue
    @JsonProperty("data")
    private Object data;
}

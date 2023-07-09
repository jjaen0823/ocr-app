package com.hanwha.ocrapp.adapter.out.feign.dto.response.hyphen;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HyphenResidentsDocumentResponse {
    @JsonProperty("common")
    private Common common;
    @JsonProperty("data")
    private Data data;

    @ToString
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class Common {  // 중요 데이터 X
        private String userTrNo;
        private String hyphenTrNo;
        private String errYn;
        private String errMsg;
    }

    /**
     * div
     */
    @ToString
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data {
        @JsonProperty("등본주소변동내역")
        private List<Objects> addressChangeDetails;
        @JsonProperty("변동내역")
        private List<ChangeDetail> changeDetails;
        @JsonProperty("세대구성_사유")
        private String genCompositionReason;
        @JsonProperty("세대구성_일자")
        private String genCompositionDate;
        @JsonProperty("세대주_성명")
        private String householderName;
        @JsonProperty("주소내역")
        private List<Address> addressList;

        @ToString
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class ChangeDetail {
            @JsonProperty("등록상태")
            private String div;
            @JsonProperty("발생일")
            private String occurrenceDate;
            @JsonProperty("번호")
            private String number;
            @JsonProperty("변동사유")
            private String changeReason;
            @JsonProperty("성명")
            private String name;
            @JsonProperty("세대주관계")
            private String householderRel;
            @JsonProperty("신고일")
            private String declarationDate;
            @JsonProperty("주민등록번호")
            private String personalNum;
        }
        @ToString
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Address {
            @JsonProperty("구분")
            private String div;
            @JsonProperty("발생일")
            private String occurrenceDate;
            @JsonProperty("변동사유")
            private String changeReason;
            @JsonProperty("신고일")
            private String declarationDate;
            @JsonProperty("주소")
            private String address;
        }
    }
}

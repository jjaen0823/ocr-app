package com.hanwha.ocrapp.adapter.out.feign.dto.response.hyphen;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@JsonIgnoreProperties(ignoreUnknown=true)  // 지정한 field 제외하고 모두 무시
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)  // null 데이터와 Optional(=absent) 제외
public class HyphenFamilyDocumentResponse {
    @JsonProperty("common")
    private Common common;
    @JsonProperty("data")
    private Data data;

    @ToString
    @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class Common {  // 중요 데이터 X
        private String userTrNo;
        private String hyphenTrNo;
        private String errYn;
        private String errMsg;

    }

    /**
     * div 구분
     * name 이름
     * birthDay 출생년월일
     * issueNo 발행번호
     * regAddr 등록기준지
     * regNo 주민등록번호
     * sex 성별
     * root 본
     */
    @ToString
    @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class Data {
        private String div;
        private String name;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy년 MM월 dd일")
        private LocalDate birthDay;
        private String issueNo;
        private String regAddr;
        private String regNo;
        private String sex;
        private String root;
        private List<DetailData> list;
        private List<DetailData> detailList;

        @ToString
        @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
        public static class DetailData {
            private String detail;
            private String div;
        }
    }
}

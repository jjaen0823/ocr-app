package com.hanwha.ocrapp.adapter.out.feign.dto.response.naver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties(ignoreUnknown=true)  // 지정한 field 제외하고 모두 무시
@JsonInclude(value = JsonInclude.Include.NON_ABSENT)  // null 데이터와 Optional(=absent) 제외
public class NaverOCRIDCardResponse {
    private List<Image> images;
    private String requestId;
    private long timestamp;
    private String version;

    @ToString
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class Image {
        private IDCard idCard;
        private String inferResult;
        private String message;
        private String name;
        @JsonProperty("uid")
        private String uid;
        private ValidationResult validationResult;

        @ToString
        @Getter
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
        public static class IDCard {
            private Meta meta;
            private Result result;

            @ToString
            @Getter
            @NoArgsConstructor
            @AllArgsConstructor
            @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
            public static class Meta {
                private String estimatedLanguage;

            }
            @ToString
            @Getter
            @NoArgsConstructor
            @AllArgsConstructor
            @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
            public static class Result {
                @JsonProperty("idtype")
                private String idtype;
                @JsonProperty("isConfident")
                private boolean isConfident;
                private List<BoundingPoly> rois;
                private IC ic;

                @ToString
                @Getter
                @NoArgsConstructor
                @AllArgsConstructor
                @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
                public static class IC {
                    private List<Name> name;
                    private List<PersonalNum> personalNum;
                    private List<Address> address;
                    private List<IssueDate> issueDate;
                    private List<Authority> authority;

                    @ToString
                    @Getter
                    @NoArgsConstructor
                    @AllArgsConstructor
                    @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
                    public static class Name {
                        private String text;
                        private FormattedValue formatted;
                        private List<BoundingPoly> boundingPolys;
                        private List<BoundingPoly> maskingPolys;
                    }
                }
                @ToString
                @Getter
                @NoArgsConstructor
                @AllArgsConstructor
                @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
                public static class PersonalNum {
                    private String text;
                    private FormattedValue formatted;
                    private List<BoundingPoly> boundingPolys;
                    private List<BoundingPoly> maskingPolys;
                }
                @ToString
                @Getter
                @NoArgsConstructor
                @AllArgsConstructor
                @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
                public static class Address {
                    private String text;
                    private FormattedValue formatted;
                    private List<BoundingPoly> boundingPolys;
                    private List<BoundingPoly> maskingPolys;

                }

                @ToString
                @Getter
                @NoArgsConstructor
                @AllArgsConstructor
                @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
                public static class IssueDate {
                    private String text;
                    private FormattedDate formatted;
                    private List<BoundingPoly> boundingPolys;
                    private List<BoundingPoly> maskingPolys;

                @ToString
                    @Getter
                    @NoArgsConstructor
                    @AllArgsConstructor
                    @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
                    public static class FormattedDate {
                        private String year;
                        private String month;
                        private String day;

//                        public FormattedDate(String year, String month, String day) {
//                            this.year = Integer.parseInt(year);
//                            this.month = Integer.parseInt(month);
//                            this.day = Integer.parseInt(day);
//                        }
                    }
                }

                @ToString
                @Getter
                @NoArgsConstructor
                @AllArgsConstructor
                @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
                public static class Authority {
                    private String text;
                    private FormattedValue formatted;
                    private List<BoundingPoly> boundingPolys;
                    private List<BoundingPoly> maskingPolys;
                }
            }
        }
    }

    @ToString
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class ValidationResult {
        private String result;
    }

    @ToString
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class FormattedValue {
        private String value;
    }

    @ToString
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class BoundingPoly {
        private List<Vertex> vertices;
    }

    @ToString
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    public static class Vertex {
        private double x;
        private double y;
    }
}
package com.hanwha.ocrapp.adapter.in.web.dto.response;

import com.hanwha.ocrapp.adapter.out.feign.dto.response.hyphen.HyphenFamilyDocumentResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@Builder
public class FamiliesInfoResponse {
    private List<FamilyInfo> familyInfo;

    @Getter
    @ToString
    @Builder
    public static class FamilyInfo {
        private String div;
        private String name;
        private String sex;
        private String personalNum;
    }
}

package com.hanwha.ocrapp.adapter.out.feign.dto.request.hyphen;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LoginMethod {
    EASY("EASY");

    private final String value;
}

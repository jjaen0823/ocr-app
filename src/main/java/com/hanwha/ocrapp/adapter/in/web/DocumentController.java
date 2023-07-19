package com.hanwha.ocrapp.adapter.in.web;

import com.hanwha.ocrapp.adapter.in.web.dto.request.FamilyDocumentInfoRequest;
import com.hanwha.ocrapp.adapter.in.web.dto.response.FamiliesInfoResponse;
import com.hanwha.ocrapp.application.port.in.DocumentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/documents")
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentUseCase documentUseCase;

    @GetMapping("/test")
    public String testAPI() {
        return "SUCCESS";
    }

    @PostMapping(value = "/families")
    public FamiliesInfoResponse certificateFamilyDocument(@RequestBody FamilyDocumentInfoRequest request) {

        return documentUseCase.getFamiliesInfoList(request);
    }

    @PostMapping(value = "/residents")
    public String certificateResidentsDocument(
        // TODO 주민등록등본 발급을 위한 개인정보
    ) {
        return "";
    }

}


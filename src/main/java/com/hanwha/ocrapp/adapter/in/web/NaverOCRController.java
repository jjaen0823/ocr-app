package com.hanwha.ocrapp.adapter.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/ocr")
public class NaverOCRController {

    @PostMapping(value = "/id-card/files")
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        // TODO File Upload
        // TODO 신분증 업로드 -> 고객 정보 리턴
        return "";
    }

}

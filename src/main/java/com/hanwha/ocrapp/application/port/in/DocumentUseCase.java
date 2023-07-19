package com.hanwha.ocrapp.application.port.in;

import com.hanwha.ocrapp.adapter.in.web.dto.request.FamilyDocumentInfoRequest;
import com.hanwha.ocrapp.adapter.in.web.dto.response.FamiliesInfoResponse;

public interface DocumentUseCase {

    FamiliesInfoResponse getFamiliesInfoList(FamilyDocumentInfoRequest request);

}

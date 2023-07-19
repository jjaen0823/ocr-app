package com.hanwha.ocrapp.adapter.out.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.naver.NaverOCRImage;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.naver.NaverOCRImageFormat;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.naver.NaverOCRMultipartFormImage;
import com.hanwha.ocrapp.adapter.out.feign.dto.request.naver.NaverOCRRequest;
import com.hanwha.ocrapp.adapter.out.feign.dto.response.naver.NaverOCRIDCardResponse;
import com.hanwha.ocrapp.adapter.out.feign.dto.response.naver.NaverOCRIDCardResponseSimple;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@SpringBootTest
class NaverOCRClientTest {
    private static final String FILE_NAME = "test.png";

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private NaverOCRClient naverOCRClient;

    private File getIDCardFile(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return new File(Objects.requireNonNull(classloader.getResource(fileName)).getFile());
    }

    private MultipartFile fileToMultipartfile(File file) throws IOException {
        FileInputStream input = new FileInputStream(file);
        return new MockMultipartFile("file", file.getName(), "text/plain",
                IOUtils.toByteArray(input));
    }
    private NaverOCRRequest getImageData(String imageName, NaverOCRImageFormat imageFormat) {
        NaverOCRImage hanwhalifeImage = new NaverOCRMultipartFormImage(imageName, imageFormat.getValue());
        return new NaverOCRRequest(UUID.randomUUID().toString(), System.currentTimeMillis(), List.of(hanwhalifeImage));
    }

    @DisplayName("Naver OCR API ID card Request Test - NaverOCRIDCardResponseSimple")
    @Test
    public void getIdCardDataUsingMultipartFormSimple() throws IOException {
        // Get file
        File file = getIDCardFile(FILE_NAME);
        Assertions.assertThat(file.exists()).isTrue();

        // File to MultipartFile
        MultipartFile multipartFile = fileToMultipartfile(file);

        // Make image data
        String valueAsString = objectMapper.writeValueAsString(getImageData(file.getName(), NaverOCRImageFormat.png));

        // Request
        ResponseEntity<NaverOCRIDCardResponseSimple> response = naverOCRClient.getIDCardDataUsingMultipartFormSimple(multipartFile, valueAsString);

        // Validation
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getStatusCode().value()).isEqualTo(200);

        // Response
        log.info(response.getBody().toString());
    }

    @DisplayName("Naver OCR API ID card Request Test - NaverOCRIDCardResponse")
    @Test
    public void getIdCardDataUsingMultipartForm() throws IOException {
        // Get file
        File file = getIDCardFile(FILE_NAME);
        Assertions.assertThat(file.exists()).isTrue();

        // File to MultipartFile
        MultipartFile multipartFile = fileToMultipartfile(file);

        // Make image data
        // json string 으로 안 바꾸면 message null 에러 발생
        String valueAsString = objectMapper.writeValueAsString(getImageData("hanwhalife_image2", NaverOCRImageFormat.png));

        // Request
        ResponseEntity<NaverOCRIDCardResponse> response = naverOCRClient.getIDCardDataUsingMultipartForm(multipartFile, valueAsString);

        // Validation
        Assertions.assertThat(response.getStatusCode().value()).isEqualTo(200);
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().getImages().toString()).contains("990823");

        // Response
        log.info(response.getBody().toString());
        log.info("=========================================");
        log.info(response.getBody().getImages().toString());
    }

    @Test
    public void test() throws IOException {
        // Get file
        File file = getIDCardFile(FILE_NAME);
        Assertions.assertThat(file.exists()).isTrue();

        // File to MultipartFile
        MultipartFile multipartFile = fileToMultipartfile(file);
        String filenameExtension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
        NaverOCRImageFormat naverOCRImageFormat = NaverOCRImageFormat.valueOf("Ss");
        log.info(String.valueOf(filenameExtension));
        log.info(String.valueOf(naverOCRImageFormat));
    }
}
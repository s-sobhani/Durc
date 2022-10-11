package com.example.durc.Durc.controller;

import com.example.durc.Durc.dto.FileUploadResponse;
import com.example.durc.Durc.service.FileStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class UploadDownloadController {

    private FileStorageService fileStorageService;

    public UploadDownloadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }
    @PostMapping("single/double")
    FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file){

        String fileName =fileStorageService.storeFile(file);
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download")
                .path(fileName)
                .toUriString();

        String contentType = file.getContentType();
        FileUploadResponse response = new FileUploadResponse(fileName, contentType, url);
        return response;
    }

}

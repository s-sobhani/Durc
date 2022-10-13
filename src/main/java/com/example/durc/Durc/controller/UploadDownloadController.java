package com.example.durc.Durc.controller;

//import com.example.durc.Durc.dto.FileUploadResponse;
import com.example.durc.Durc.service.FileStorageService;
import com.example.durc.Durc.service.impl.FileStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class UploadDownloadController {

    private FileStorageService fileStorageService;

    @Autowired
    private FileStorageServiceImpl service;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = service.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageData=service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToTheFileSystem(@RequestParam("image")MultipartFile file) throws IOException{
        String uploadImage = service.uploadImageToTheFileSystem(file);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImageFromTheFileSystem(@PathVariable String fileName){
        byte[] imageData=service.downloadImageFromTheFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }

//    public UploadDownloadController(FileStorageService fileStorageService) {
//        this.fileStorageService = fileStorageService;
//    }
//
//    @PostMapping("single/double")
//    FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file){
//
//        String fileName =fileStorageService.storeFile(file);
//        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/download")
//                .path(fileName)
//                .toUriString();
//
//        String contentType = file.getContentType();
//        FileUploadResponse response = new FileUploadResponse(fileName, contentType, url);
//        return response;
//    }

}

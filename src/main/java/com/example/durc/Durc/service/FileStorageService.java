package com.example.durc.Durc.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {

    String uploadImage(MultipartFile file) throws IOException;
    byte[] downloadImage(String file_name);
    String uploadImageToTheFileSystem(MultipartFile file) throws IOException;
    byte[] downloadImageFromTheFileSystem(String file_name);
}

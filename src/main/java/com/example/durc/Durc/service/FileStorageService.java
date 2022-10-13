package com.example.durc.Durc.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {

    public String uploadImage(MultipartFile file) throws IOException;
    public byte[] downloadImage(String file_name);
    public String uploadImageToTheFileSystem(MultipartFile file) throws IOException;
    public byte[] downloadImageFromTheFileSystem(String file_name);
}

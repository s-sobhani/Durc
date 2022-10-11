package com.example.durc.Durc.service.impl;

import com.example.durc.Durc.service.FileStorageService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    Path fileStoragePath;

    public FileStorageServiceImpl(@Value("${file.storage.location:temp}") String fileStorageLocation ) {
        fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();

        try {
            Files.createDirectories(fileStoragePath);
        } catch (IOException e) {
            throw new RuntimeException("Issue in creating file directory.");
        }
    }

    @Override
    public String storeFile(MultipartFile file) {
        return null;

    }
}

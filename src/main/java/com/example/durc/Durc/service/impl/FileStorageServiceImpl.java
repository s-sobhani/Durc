package com.example.durc.Durc.service.impl;

import com.example.durc.Durc.model.ImageData;
import com.example.durc.Durc.repository.StorageRepository;
import com.example.durc.Durc.service.FileStorageService;
import com.example.durc.Durc.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
public class FileStorageServiceImpl implements FileStorageService {


    @Autowired
    private StorageRepository storageRepository;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {

        ImageData imageData = storageRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build()
        );

        if (imageData != null) {

            return "File was uploaded successfully: " + file.getOriginalFilename();
        } else
            return null;
    }

    @Override
    @Transactional
    public byte[] downloadImage(String file_name) {

        Optional<ImageData> dbImageData = storageRepository.findByName(file_name);
        byte[] images = ImageUtil.decompressImage(dbImageData.get().getImageData());
        return images;
    }

    @Override
    public String uploadImageToTheFileSystem(MultipartFile file) throws IOException {

//        ImageData imageData = storageRepository.save(ImageData.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtil.compressImage(file.getBytes())).build()
//        );
//
//        if (imageData != null) {
//
//            return "File was uploaded successfully: " + file.getOriginalFilename();
//        } else
//            return "An error occurred while uploading" + file.getOriginalFilename();
        return null;
    }

    @Override
    public byte[] downloadImageFromTheFileSystem(String file_name) {

//        Optional<ImageData> dbImageData = storageRepository.findByName(file_name);
//        byte[] images = ImageUtil.decompressImage(dbImageData.get().getImageData());
//        return images;
        return null;
    }
}
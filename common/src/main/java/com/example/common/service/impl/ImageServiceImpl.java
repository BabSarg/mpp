package com.example.common.service.impl;


import com.example.common.model.Image;
import com.example.common.repository.ImageRepository;
import com.example.common.service.ImageService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    public final ImageRepository imageRepository;

    @Value("${image.upload.dir}")
    private String imageUploadDir;


    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public boolean isExists(int id) {
        return imageRepository.findById(id).isPresent();
    }


    @Override
    public Image addImage(MultipartFile file) throws IOException {

        String fileName = System.currentTimeMillis() + " " + file.getOriginalFilename();
        File uploadFile = new File(imageUploadDir,fileName);
        file.transferTo(uploadFile);
        Image image = Image.builder()
                .name(fileName)
                .build();
        imageRepository.save(image);
        return image;
    }

    @Override
    public void deleteImageById(int id) {
        imageRepository.deleteById(id);

    }

    @Override
    public byte[] getImage(String name) {

        InputStream in = null;
        try {
            in = new FileInputStream(imageUploadDir + name);
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Image image) {
        imageRepository.save(image);
    }

    @Override
    public Optional<Image> findByUserId(int userId) {
        return imageRepository.findById(userId);
    }

//get
}

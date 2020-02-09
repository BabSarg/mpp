package com.example.common.service;

import com.example.common.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface ImageService {

    boolean isExists(int id);

    Image addImage(MultipartFile file) throws IOException;

    void deleteImageById(int id);

    byte[] getImage(String name);

    void save(Image image);

    Optional<Image> findByUserId(int userId);

}

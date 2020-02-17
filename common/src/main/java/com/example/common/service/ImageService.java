package com.example.common.service;

import com.example.common.model.Image;
import com.example.common.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ImageService {

    boolean isExists(int id);

    Image addImage(List<Integer> categories, MultipartFile file, User user) throws IOException;

    void deleteImageById(int id);

    byte[] getImage(String name);

    void save(Image image);

    Optional<Image> findByUserId(int userId);

}

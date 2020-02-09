package com.example.common.service;

import com.example.common.model.Category;

import java.util.List;

public interface CategoryService {

    boolean isExists(int id);

    List<Category> findAll();

    void addCategory(Category category);

    void deleteById(int id);
}

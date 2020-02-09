package com.example.common.service.impl;


import com.example.common.exception.UserNotFoundException;
import com.example.common.model.Category;
import com.example.common.repository.CategoryRepository;
import com.example.common.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public boolean isExists(int id) {
        return categoryRepository.findById(id).isPresent();
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }


}

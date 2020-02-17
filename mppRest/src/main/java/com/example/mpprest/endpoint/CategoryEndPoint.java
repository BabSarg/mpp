package com.example.mpprest.endpoint;


import com.example.common.model.Category;
import com.example.common.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/categories")
@CrossOrigin(origins = "*")

public class CategoryEndPoint {

    private final CategoryService categoryService;

    public CategoryEndPoint(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public List<Category> findAll(){
        return categoryService.findAll();
    }

}

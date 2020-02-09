package com.example.common.service;

import com.example.common.model.Category;
import com.example.common.model.MultiCat;

import java.util.List;

public interface MultiCatService {

    void save(MultiCat multiCat);

    List<MultiCat> findAll();

    List<MultiCat> findByName(String name);



    void deleteById(int id);


    List<MultiCat> findByCategories(Category category);
}

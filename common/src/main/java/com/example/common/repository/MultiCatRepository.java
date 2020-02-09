package com.example.common.repository;

import com.example.common.model.Category;
import com.example.common.model.Movie;
import com.example.common.model.MultiCat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultiCatRepository extends JpaRepository<MultiCat,Integer> {

    List<MultiCat> findByName(String name);


    List<MultiCat> findByCategories(Category category);



}

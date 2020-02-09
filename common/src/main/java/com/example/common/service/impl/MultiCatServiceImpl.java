package com.example.common.service.impl;


import com.example.common.model.Category;
import com.example.common.model.Movie;
import com.example.common.model.MultiCat;
import com.example.common.repository.MultiCatRepository;
import com.example.common.service.MultiCatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultiCatServiceImpl implements MultiCatService {

    private final MultiCatRepository multiCatRepository;

    public MultiCatServiceImpl(MultiCatRepository multiCatRepository) {
        this.multiCatRepository = multiCatRepository;
    }


    public void save(MultiCat multiCat) {
        multiCatRepository.save(multiCat);
    }

    public List<MultiCat> findAll(){
        return multiCatRepository.findAll();
    }

    public List<MultiCat> findByName(String name) {
        return multiCatRepository.findByName(name);
    }






    @Override
    public void deleteById(int id) {

        multiCatRepository.deleteById(id);
    }

    public List<MultiCat> findByCategories(Category category){
        return multiCatRepository.findByCategories(category);
    }


}

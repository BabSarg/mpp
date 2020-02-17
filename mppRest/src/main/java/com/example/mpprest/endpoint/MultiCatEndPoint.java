package com.example.mpprest.endpoint;


import com.example.common.model.Category;
import com.example.common.model.MultiCat;
import com.example.common.service.MultiCatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/multiCat")
@CrossOrigin(origins = "*")

public class MultiCatEndPoint {

    private final MultiCatService multiCatService;

    public MultiCatEndPoint(MultiCatService multiCatService) {
        this.multiCatService = multiCatService;
    }

    @GetMapping
    public List<MultiCat> findAll(){
        return multiCatService.findAll();
    }

    @GetMapping("/findByName")
    public ResponseEntity findByName(@RequestParam("name") String movieName){
        return ResponseEntity.ok(multiCatService.findByName(movieName));
    }
    @GetMapping("/findByCategory")
    public List<MultiCat> findByCategories(@RequestParam("category") Category category){
        return multiCatService.findByCategories(category);
    }

}

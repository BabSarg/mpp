package com.example.mpprest.endpoint;


import com.example.common.model.Image;
import com.example.common.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rest/images")
@CrossOrigin(origins = "*")

public class ImageEndPoint {

    private final ImageService imageService;

    public ImageEndPoint(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/user")
    public ResponseEntity findByUserId(@RequestParam("userId") int userId) {
        return ResponseEntity.ok(imageService.findByUserId(userId));

    }


}

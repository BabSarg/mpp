package com.example.mppadmin.controller;


import com.example.common.service.CategoryService;
import com.example.common.service.ImageService;
import com.example.common.service.UserService;
import com.example.mppadmin.security.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final ImageService imageService;
    private final CategoryService categoryService;


    public UserController(UserService userService,
                          ImageService imageService,
                          CategoryService categoryService) {
        this.userService = userService;
        this.imageService = imageService;
        this.categoryService = categoryService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }



    @GetMapping("/activate")
    public String activate(@RequestParam("token") String token) {
        userService.activateUser(token);
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        modelMap.addAttribute("user", currentUser.getUser());
        modelMap.addAttribute("categories", categoryService.findAll());
        return "profile";
    }

    @PostMapping("/addImage")
    public String addImage(@RequestParam("categories") List<Integer> categories,
                           @RequestParam("image") MultipartFile multipartFile, @AuthenticationPrincipal CurrentUser currentUser) throws IOException {
        imageService.addImage(categories, multipartFile, currentUser.getUser());
        return "redirect:/profile";
    }

}

package com.example.mpprest.endpoint;


import com.example.common.exception.UserNotFoundException;
import com.example.common.model.Image;
import com.example.common.model.Movie;
import com.example.common.model.User;
import com.example.common.service.ImageService;
import com.example.common.service.MovieService;
import com.example.common.service.UserService;
import com.example.mpprest.dto.AuthenticationRequest;
import com.example.mpprest.dto.AuthenticationResponse;
import com.example.mpprest.dto.UserDto;
import com.example.mpprest.security.CurrentUser;
import com.example.mpprest.security.JwtTokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserEndPoint {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final ImageService imageService;
    private final MovieService movieService;

    public UserEndPoint(PasswordEncoder passwordEncoder, UserService userService, JwtTokenUtil jwtTokenUtil, ImageService imageService, MovieService movieService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.imageService = imageService;
        this.movieService = movieService;
    }


    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody AuthenticationRequest authenticationRequest) {
        User user = null;
        try {
            user = userService.findByEmail(authenticationRequest.getEmail());
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
        if (passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword())) {
            String token = jwtTokenUtil.generateToken(user.getEmail());
            return ResponseEntity.ok(AuthenticationResponse.builder()
                    .token(token)
                    .userDto(UserDto.builder()
                            .id(user.getId())
                            .name(user.getName())
                            .surname(user.getSurname())
                            .email(user.getEmail())
                            .userType(user.getUserType())
                            .build())
                    .build());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }


    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user) {
        if (userService.isExists(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return ResponseEntity.ok(user.getId());
    }


    @PutMapping("/addImage/{userId}")
    public ResponseEntity addImage(@PathVariable("userId") int userId, @RequestParam(value = "file") MultipartFile file) {
        try {
            User byId = userService.findById(userId);
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File uploadFile = new File("C:\\Users\\Mher\\Desktop\\mpp\\imageUploadDir\\", fileName);
            file.transferTo(uploadFile);
            Image image = new Image();
            image.setName(fileName);
            imageService.save(image);
            byId.setImage(image);
            userService.save(byId);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().build();
    }


    @GetMapping("/movieByUserId")
    public void findMovieByUserId(@RequestParam (value = "movies") List<Integer> movies,@AuthenticationPrincipal CurrentUser user) throws UserNotFoundException {

        User byUserId = userService.findById(user.getUser().getId());
        List<Movie> movieList = movieService.addMovie(movies);
        byUserId.setMovies(movieList);
        userService.save(byUserId);
    }


}
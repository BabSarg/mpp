package com.example.common.service;

import com.example.common.exception.UserNotFoundException;
import com.example.common.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User isExists(String email) throws UserNotFoundException;

    Optional<User> isExists(int id) throws UserNotFoundException;

    List<User> findAll();

    void save(User user);

    Optional<User> findById(int id) throws UserNotFoundException;

    User findByEmail(String email) throws UserNotFoundException;

    void deleteById(int id);

    void activateUser(String token);

    void registerUser(User user);
}

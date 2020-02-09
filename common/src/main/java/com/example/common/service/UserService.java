package com.example.common.service;

import com.example.common.exception.UserNotFoundException;
import com.example.common.model.User;

import java.util.List;

public interface UserService {

    boolean isExists(String email);

    boolean isExists(int id);

    List<User> findAll();

    void save(User user);

    User findById(int id) throws UserNotFoundException;

    User findByEmail(String email) throws UserNotFoundException;

    void deleteById(int id);

}

package com.example.common.service.impl;

import com.example.common.exception.UserNotFoundException;
import com.example.common.model.User;
import com.example.common.repository.UserRepository;
import com.example.common.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isExists(String email){
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean isExists(int id) {
        return userRepository.findById(id).isPresent();
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }


    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(int id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User findByEmail(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }


}

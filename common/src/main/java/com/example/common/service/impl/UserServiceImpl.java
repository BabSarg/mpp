package com.example.common.service.impl;

import com.example.common.exception.UserNotFoundException;
import com.example.common.model.User;
import com.example.common.service.UserService;
import com.example.common.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailServiceImpl mailServiceImpl;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, MailServiceImpl mailServiceImpl) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailServiceImpl = mailServiceImpl;
    }


    @Override
    public User isExists(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> isExists(int id) throws UserNotFoundException {
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }


    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<User> findById(int id) throws UserNotFoundException {
        return userRepository.findById(id);
    }



    public User findByEmail(String email)  {
        return userRepository.findByEmail(email);

    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }



    public void activateUser(String token) {
        User byToken = userRepository.findByToken(token);
        if (byToken != null) {
            byToken.setEnable(true);
            byToken.setToken(null);
            userRepository.save(byToken);
            mailServiceImpl.sendMessageWithAttachment(byToken.getEmail(),"Success","Success","C:\\Users\\Vard\\Desktop\\mpp\\moviePortal\\image\\");
        }
    }

    @Override
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnable(false);
        user.setToken(UUID.randomUUID().toString());
        userRepository.save(user);
        String link = "http://localhost:8081/activate?token=" + user.getToken();
        mailServiceImpl.sendSimpleMessage(user.getEmail(),
                "Welcome",
                "Congratulations! you have successfully register to system! \n" +
                        "You have to activate your account by this link " + link);
    }


}

package com.example.common.repository;

import com.example.common.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);


    User findByToken(String token);


//    boolean isExists(String email);

//    boolean isExists(int id);

//    User findBy(int id);


//    boolean findById(int id) throws UserNotFoundException;

//    boolean findUserByEmail(String email) throws UserNotFoundException;
}

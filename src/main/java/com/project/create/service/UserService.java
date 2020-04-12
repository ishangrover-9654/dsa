package com.project.create.service;

import com.project.create.model.Users;
import com.project.create.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(Users users){
        userRepository.save(users);
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }
}

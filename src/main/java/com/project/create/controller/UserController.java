package com.project.create.controller;

import com.project.create.model.Users;
import com.project.create.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Users user){
        userService.saveUser(user);
        return new ResponseEntity<>("User Created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Users>> getUsers(){
        List<Users> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}

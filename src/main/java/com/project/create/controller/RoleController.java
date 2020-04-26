package com.project.create.controller;

import com.project.create.model.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles/")
public class RoleController {

    public ResponseEntity<Object> create(@RequestBody Role role){
        return null;
    }
}

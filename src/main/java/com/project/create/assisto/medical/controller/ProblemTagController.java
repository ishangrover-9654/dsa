package com.project.create.assisto.medical.controller;

import com.project.create.assisto.medical.ProblemTagRepository;
import com.project.create.assisto.medical.model.ProblemsTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/problems")
public class ProblemTagController {

    @Autowired
    ProblemTagRepository problemTagRepository;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody List<ProblemsTag> problemsTags){
        problemsTags = problemTagRepository.saveAll(problemsTags);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProblemsTag>> getAll(){
        System.out.println("in get all");
        List<ProblemsTag> problemsTags = problemTagRepository.findAll();
        System.out.println(problemsTags);
        return new ResponseEntity(problemsTags, HttpStatus.OK);
    }

}

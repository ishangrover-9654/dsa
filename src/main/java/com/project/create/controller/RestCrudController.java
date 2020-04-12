package com.project.create.controller;

import com.project.create.model.SampleEntity;
import com.project.create.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/entities")
@Slf4j
public class RestCrudController {

    @Inject //or Autowired
    CrudService crudService;

    @GetMapping("/{id}")
    public void getEntity(@PathVariable  Long id, @RequestBody SampleEntity sampleEntity){
        log.info("Get1 request with id {}", id);
        crudService.save(sampleEntity);
    }

    @GetMapping("/get2/{id}")
    public ResponseEntity<String> getEntity(@PathVariable  Long id){
        //crudService.getEntityById(id);
        log.info("Get2 request with id {}", id);
        crudService.save(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/post/{id}")
    public ResponseEntity<String> postEntity(@PathVariable  Long id){
        //crudService.getEntityById(id);
        log.info("Post request with id {}", id);
        crudService.save(id);

        return new ResponseEntity(HttpStatus.OK);
    }

}

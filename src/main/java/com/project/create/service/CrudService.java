package com.project.create.service;


import com.project.create.model.SampleEntity;
import com.project.create.repository.SampleCrudRepository;
import javassist.tools.rmi.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrudService {

    @Autowired
    SampleCrudRepository sampleCrudRepository;

    public void getEntities(){
        sampleCrudRepository.findAll();
    }

    public SampleEntity getEntityById(Long id){
         return sampleCrudRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity Not Found"));
    }

    public void deleteById(){
        sampleCrudRepository.deleteById(0L);
    }

    public void save(SampleEntity sampleEntity) {
        /*sampleEntity.setId(1);
        sampleEntity.setName("name1");
        sampleEntity.setValue("value1");*/
        sampleCrudRepository.save(sampleEntity);
    }

    public void save(Long id) {
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setId(id);
        sampleEntity.setName("name"+id);
        sampleEntity.setValue("value"+id);
        sampleCrudRepository.save(sampleEntity);
    }
}

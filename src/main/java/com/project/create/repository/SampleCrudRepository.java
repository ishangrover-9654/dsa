package com.project.create.repository;

import com.project.create.model.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleCrudRepository extends JpaRepository<SampleEntity, Long> {


}

package com.project.create.assisto.medical.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.project.create.assisto.medical.model.ProblemsTag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemTagRepository extends ArangoRepository<ProblemsTag, String> {
}

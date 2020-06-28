package com.project.create.assisto.medical;

import com.project.create.assisto.medical.model.ProblemsTag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemTagRepository extends MongoRepository<ProblemsTag, String> {
}

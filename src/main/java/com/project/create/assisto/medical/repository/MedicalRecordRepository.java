package com.project.create.assisto.medical.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.project.create.assisto.medical.model.MedicalRecord;

public interface MedicalRecordRepository extends ArangoRepository<MedicalRecord, String> {

}

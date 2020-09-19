package com.project.create.assisto.medical.runner;

import com.project.create.assisto.medical.model.ProblemsTag;
import com.project.create.assisto.medical.repository.MedicalRecordRepository;
import com.project.create.assisto.medical.repository.ProblemTagRepository;
import org.springframework.boot.CommandLineRunner;


public class ArangoRunner implements CommandLineRunner {
    MedicalRecordRepository recordRepository;
    ProblemTagRepository tagRepository;
    @Override
    public void run(String... args) throws Exception {
        ProblemsTag problemsTag = new ProblemsTag();
        problemsTag.setName("Fever");

        tagRepository.save(problemsTag);
    }
}

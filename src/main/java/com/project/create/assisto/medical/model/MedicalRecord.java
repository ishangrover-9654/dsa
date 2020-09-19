package com.project.create.assisto.medical.model;

import com.arangodb.springframework.annotation.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Document @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MedicalRecord {

    @Id
    String id;

    private String medRecordName;
    private String treatCenter;


}

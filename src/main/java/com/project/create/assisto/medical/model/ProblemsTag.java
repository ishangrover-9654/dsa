package com.project.create.assisto.medical.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document @AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class ProblemsTag {
    @Id
    private String id;
    private String name;
}

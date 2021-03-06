package com.project.create.assisto.medical.model;

import com.arangodb.springframework.annotation.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Document
@AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class ProblemsTag {
    @Id
    private String id;
    private String name;
}

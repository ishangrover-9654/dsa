package com.project.practice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor @ToString
public class CusEntity {
    private Integer id;
    private String name;
    private String value;
    private int age;
}

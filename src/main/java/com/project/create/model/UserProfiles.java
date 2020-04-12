package com.project.create.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class UserProfiles extends BaseEntity{

    private String address;
    private String phoneNum;

    //@JsonBackReference
    //@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id")
    //private Users users;
}

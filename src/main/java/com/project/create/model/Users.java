package com.project.create.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
@Table(name = "users")
public class Users extends BaseEntity{

    private String name;
    private String email;

    //@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    //private Set<Role> roles;
    //@JsonManagedReference
    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private UserProfiles userProfiles;
}

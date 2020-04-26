package com.project.create.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity @Getter @Setter
@Table(name = "users")
public class Users extends BaseEntity{

    private String name;
    private String email;

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role" , joinColumns = { @JoinColumn(name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;*/
    //@JsonManagedReference
    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private UserProfiles userProfiles;

    @OneToMany(mappedBy = "users")
    private Set<UserRole> userRoles;
}

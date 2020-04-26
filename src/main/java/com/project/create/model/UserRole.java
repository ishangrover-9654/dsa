package com.project.create.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class UserRole {

    //@EmbeddedId
    //UserRoleKey id;

    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    @JoinColumn(name = "id")
    Users users;

    @ManyToOne
    @MapsId("role_id")
    @JoinColumn(name = "id")
    Role role;



}

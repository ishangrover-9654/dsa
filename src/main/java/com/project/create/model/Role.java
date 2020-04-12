package com.project.create.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Role extends BaseEntity
{

    private String roleName;

   // @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "id")
    //private User user;

}

package com.project.create.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role extends BaseEntity
{

    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<UserRole> userRoles;

   // @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "id")
    //private User user;

}

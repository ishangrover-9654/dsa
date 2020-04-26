package com.project.create.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable @Getter @Setter
public class UserRoleKey implements Serializable {
    @Column(name = "user_id")
    private long userId;

    @Column(name = "role_id")
    private long roleId;

}

package com.example.cb.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Role {
    @Id
    @Column(name = "Id")
    private String role_id;

    @Column(name = "Role", nullable = false)
    private String role;

    public Role(String role_id, String role) {
        this.role_id = role_id;
        this.role = role;
    }

    public Role(){}

}

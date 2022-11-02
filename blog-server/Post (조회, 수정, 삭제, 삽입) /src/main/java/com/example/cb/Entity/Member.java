package com.example.cb.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Entity
public class Member {
    @Id
    @Column(name = "Id")
    private String Member_id;

    @Column(name = "password", nullable = false)
    private String Member_password;

    @Column(name = "name")
    private String Member_name;

    @Column(name = "email")
    private String Member_email;

    public Member(){}

    public Member(String member_id, String member_password, String member_name, String member_email) {
        Member_id = member_id;
        Member_password = member_password;
        Member_name = member_name;
        Member_email = member_email;
    }
}

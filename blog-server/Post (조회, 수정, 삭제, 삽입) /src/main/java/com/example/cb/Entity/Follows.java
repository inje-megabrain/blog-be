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
public class Follows {
    @Id
    @Column(name = "follow_from")
    private String follows_from;


    @Column(name = "follow_to", nullable = false)
    private String follows_to;

    public Follows(){}
    public Follows(String follows_from, String follows_to) {
        this.follows_from = follows_from;
        this.follows_to = follows_to;
    }
}

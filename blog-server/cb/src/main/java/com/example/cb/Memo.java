package com.example.cb;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Memo {
    @Id
    @GeneratedValue
    private Long id;
    private String age;
    private String name;
    public Memo(){}
    public Memo(String name,String age){
        this.age=age;
        this.name=name;
    }
}

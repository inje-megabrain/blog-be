package com.example.cb.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class tag {
    @Id
    @Column(name = "Id")
    private String tag_id;

    @Column(name = "postid", nullable = false)
    private String tag_postid;

    @Column(name = "description", nullable = false)
    private String tag_description;
    public tag(){}

    public tag(String tag_id, String tag_postid, String tag_description) {
        this.tag_id = tag_id;
        this.tag_postid = tag_postid;
        this.tag_description = tag_description;
    }
}

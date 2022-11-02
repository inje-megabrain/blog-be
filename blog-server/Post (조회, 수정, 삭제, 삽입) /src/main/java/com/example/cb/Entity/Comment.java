package com.example.cb.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Entity
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @Column(name = "Id")
    private String comment_id;


    @Column(name = "PostId", nullable = false)
    private String comment_post_id;

    @Column(name = "author", nullable = true)
    private String comment_author;

    @Column(name = "content", nullable = true)
    private String comment_content;

    @Column(name = "lastEditedAt")

    private Date comment_lastEditedAt;

    @Column(name = "createdAt")

    private Date comment_createdAt;

    @Column(name = "isSecret")
    private Boolean comment_isSecret;

    @Column(name = "_like")
    private Long comment_like;


    public String toString(){
        return "Comment{" +
                "comment_id='" + comment_id + '\'' +
                ", comment_post_id='" + comment_post_id + '\'' +
                '}';
    }
    /*
    public Comment(String comment_id, String comment_post_id, String comment_author, String comment_content, Date comment_lastEditedAt, Date comment_createdAt, Boolean comment_isSecret, Long comment_like) {
        this.comment_id = comment_id;
        this.comment_post_id = comment_post_id;
        this.comment_author = comment_author;
        this.comment_content = comment_content;
        this.comment_lastEditedAt = comment_lastEditedAt;
        this.comment_createdAt = comment_createdAt;
        this.comment_isSecret = comment_isSecret;
        this.comment_like = comment_like;
    }
    */

    public Comment(String comment_id, String comment_post_id) {
        this.comment_id = comment_id;
        this.comment_post_id = comment_post_id;
    }


}

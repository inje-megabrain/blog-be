package com.example.cb.entity;

import com.example.cb.model.CommentDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Comment {

    @Id
    @Column(name = "Id")
    private String comment_id;
    //글이름(글id)
    @Column(name = "PostId")
    private String comment_postid;

    @Column(name = "author")
    private String comment_author;

    @Column(name = "content")
    private String comment_content;

    @Column(name = "lastEditedAt")
    private Date comment_lastEditedAt;

    @Column(name = "createdAt")
    private Date comment_createdAt;

    @Column(name = "isSecret")
    private Boolean comment_isSecret;

    @Column(name = "likes")
    private Long comment_like;

    @Column(name = "parent")
    private String comment_parent;

    public Comment(){}

    public Comment(CommentDto commentDto){
        comment_id = commentDto.getId();
        comment_postid=commentDto.getPostid();
        comment_author=commentDto.getAuthor();
        comment_content=commentDto.getContent();
        comment_lastEditedAt=commentDto.getLastEditedAt();
        comment_createdAt=commentDto.getCreateAt();
        comment_isSecret=commentDto.isSecret();
        comment_like=commentDto.getLikes();
        comment_parent= commentDto.getParent();
    }

    public Comment(String comment_id, String comment_postid, String comment_author, String comment_content, Date comment_lastEditedAt, Date comment_createdAt, Boolean comment_isSecret, Long comment_like, String comment_parent) {
        this.comment_id = comment_id;
        this.comment_postid = comment_postid;
        this.comment_author = comment_author;
        this.comment_content = comment_content;
        this.comment_lastEditedAt = comment_lastEditedAt;
        this.comment_createdAt = comment_createdAt;
        this.comment_isSecret = comment_isSecret;
        this.comment_like = comment_like;
        this.comment_parent = comment_parent;
    }

}

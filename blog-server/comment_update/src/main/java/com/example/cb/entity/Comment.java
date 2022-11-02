package com.example.cb.entity;

import com.example.cb.model.CommentDto;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Entity
public class Comment {

    @Id
    @Column(name = "Id")
    private Long id;
    //글이름(글id)
    @Column(name = "PostId")
    private String postid;

    @Column(name = "author")
    private String author;

    @Column(name = "content")
    private String content;

    @Column(name = "lastEditedAt")
    private Date lastEditedAt;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "isSecret")
    private Boolean isSecret;

    @Column(name = "likes")
    private Long likes;

    @Column(name = "parent")
    private Long parent;

    public Comment(){}

    public Comment(CommentDto commentDto){
        id = commentDto.getId();
        postid =commentDto.getPostid();
        author =commentDto.getAuthor();
        content =commentDto.getContent();
        lastEditedAt =commentDto.getLastEditedAt();
        createdAt =commentDto.getCreateAt();
        isSecret =commentDto.isSecret();
        likes =commentDto.getLikes();
        parent = commentDto.getParent();
    }

    public Comment(Long comment_id, String comment_postid, String comment_author, String comment_content, Date comment_lastEditedAt, Date comment_createdAt, Boolean comment_isSecret, Long comment_like, Long comment_parent) {
        this.id = comment_id;
        this.postid = comment_postid;
        this.author = comment_author;
        this.content = comment_content;
        this.lastEditedAt = comment_lastEditedAt;
        this.createdAt = comment_createdAt;
        this.isSecret = comment_isSecret;
        this.likes = comment_like;
        this.parent = comment_parent;
    }

}

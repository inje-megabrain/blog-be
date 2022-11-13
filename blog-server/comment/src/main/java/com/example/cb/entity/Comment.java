package com.example.cb.entity;

import com.example.cb.model.CommentDto;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@Entity
public class Comment {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    private Comment(CommentDto commentDto){
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

    public Comment(Long id, String postid, String author, String content, Date lastEditedAt, Date createdAt, Boolean isSecret, Long likes, Long parent) {
        this.id = id;
        this.postid = postid;
        this.author = author;
        this.content = content;
        this.lastEditedAt = lastEditedAt;
        this.createdAt = createdAt;
        this.isSecret = isSecret;
        this.likes = likes;
        this.parent = parent;
    }

    public static Comment Commentfrom(CommentDto dto){
        return new Comment(dto);
    }

    public static CommentDto newCommentDto(Comment comment){
        return new CommentDto(comment);
    }

}

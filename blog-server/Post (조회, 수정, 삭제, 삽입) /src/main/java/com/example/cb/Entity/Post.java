package com.example.cb.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Post { //DB저장용
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 선언
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_author", nullable = false)
    private String postAuthor;

    @Column(name = "post_content")
    private String postContent;

    @Column(name = "post_like")
    private Long postLike;

    @Column(name = "post_views")
    private Long postViews;

    @Column(name = "post_is_secret", nullable = false)
    private Boolean postIsSecret;

    @Column(name = "post_create_at", nullable = false)
    private Date postCreateAt;

    @Column(name = "post_edit_at")
    private Date postEditAt;

    @Column(name = "post_temporary_save")
    private String postTemporary;

    @Column(name = "post_image")
    private String postImage;

    public Post(){}

    public Long getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public String getPostContent() {
        return postContent;
    }

    public Long getPostLike() {
        return postLike;
    }

    public Long getPostViews() {
        return postViews;
    }

    public Boolean getPostIsSecret() {
        return postIsSecret;
    }

    public Date getPostCreateAt() {
        return postCreateAt;
    }

    public Date getPostEditAt() {
        return postEditAt;
    }

    public String getPostTemporary() {
        return postTemporary;
    }

    public String getPostImage() {
        return postImage;
    }
}

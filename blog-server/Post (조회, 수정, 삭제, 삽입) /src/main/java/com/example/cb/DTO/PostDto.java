package com.example.cb.DTO;

import com.example.cb.Entity.Post;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PostDto { //뷰에서 받는 데이터들
    private Long postId;

    private String postTitle;

    private String postAuthor;

    private String postContent;

    private Long postLike;

    private Long postViews;

    private Boolean postIsSecret;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postCreateAt;  //Date를 쓸 거면 DateTimeForamt을 해줘야 쓸 수 있다.

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postEditAt;
    private String postTemporary;
    private String postImage;

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public void setPostLike(Long postLike) {
        this.postLike = postLike;
    }

    public void setPostViews(Long postViews) {
        this.postViews = postViews;
    }

    public void setPostIsSecret(Boolean postIsSecret) {
        this.postIsSecret = postIsSecret;
    }

    public void setPostCreateAt(Date postCreateAt) {
        this.postCreateAt = postCreateAt;
    }

    public void setPostEditAt(Date postEditAt) {
        this.postEditAt = postEditAt;
    }

    public void setPostTemporary(String postTemporary) {
        this.postTemporary = postTemporary;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

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

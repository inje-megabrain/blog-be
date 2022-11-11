package com.example.cb.model;

import com.example.cb.entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@AllArgsConstructor
@Data
public class CommentDto {
    @JsonProperty(value="id")
   private Long id;
    @JsonProperty(value="postid")
   private String postid;
    @JsonProperty(value="author")
   private String author;
    @JsonProperty(value="content")
   private String content;
    @JsonProperty(value="lastEditedAt")
   private Date lastEditedAt;
    @JsonProperty(value="createAt")
   private Date createAt;
    @JsonProperty(value="isSecret")
   private boolean isSecret;
    @JsonProperty(value="likes")
    private Long likes;
    @JsonProperty(value="parent")
   private Long parent;

    public CommentDto(Comment comment){
        this.id = comment.getId();
        this.postid = comment.getPostid();
        this.author=comment.getAuthor();
        this.content= comment.getContent();
        this.lastEditedAt=comment.getLastEditedAt();
        this.createAt=comment.getCreatedAt();
        this.isSecret= comment.getIsSecret();
        this.likes= comment.getLikes();
        this.parent= comment.getParent();

    }

}

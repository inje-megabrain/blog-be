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
   private String id;
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
   private String parent;

    public CommentDto(Comment comment){
        this.id = comment.getComment_id();
        this.postid = comment.getComment_postid();
        this.author=comment.getComment_author();
        this.content= comment.getComment_content();
        this.lastEditedAt=comment.getComment_lastEditedAt();
        this.createAt=comment.getComment_createdAt();
        this.isSecret= comment.getComment_isSecret();
        this.likes= comment.getComment_like();
        this.parent= comment.getComment_parent();

    }
}

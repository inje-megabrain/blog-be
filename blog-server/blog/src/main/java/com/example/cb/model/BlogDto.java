package com.example.cb.model;

import com.example.cb.entity.Blog;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@AllArgsConstructor
@Data
public class BlogDto {

    @JsonProperty(value="blog_id")
    private Long id;
    //글이름(글id)
    @JsonProperty(value="owner")
    private String owner;
    @JsonProperty(value="title")
    private String title;
    @JsonProperty(value="createAt")
    private Date createAt;
    @JsonProperty(value="removeAt")
    private Date removeAt;

    public BlogDto(Blog blog){
        id = blog.getId();
        owner = blog.getOwner();
        title = blog.getTitle();
        createAt = blog.getCreateAt();
        removeAt = blog.getRemoveAt();
    }

}

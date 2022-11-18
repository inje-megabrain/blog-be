package com.example.cb.controller;

import com.example.cb.dao.BlogDao;
import com.example.cb.entity.Blog;
import com.example.cb.model.BlogDto;
import com.example.cb.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api/v1")
public class CommentController {
    private BlogDao blogDao;
    private final BlogService blogService;

    @Autowired
    public CommentController (BlogService blogService, BlogDao blogDao){
        this.blogService = blogService;
        this.blogDao = blogDao;
    }

    //블로그 생성
    @PostMapping(value = "/blog/")
    public ResponseEntity blogAdd(@RequestBody BlogDto blogDto){
        try{
            blogService.addBlog(blogDto);
            return new ResponseEntity(blogDto.getTitle()+"글이 작성 되었습니다.",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(("잘못된 요청"),HttpStatus.BAD_REQUEST);
        }
    }

    //블로그 이름 수정
    @PostMapping(value = "/blog/{blog_id}/{title}")
    public Blog editTitle(@PathVariable("blog_id") String id, @PathVariable String title){
        return blogService.editTitle(id,title);
    }


    //블로그 삭제
    @PostMapping(value = "/blog/delete/{id}")
    public Blog blogDelete(@PathVariable String id){
        return blogService.blogDelete(id);
    }
}

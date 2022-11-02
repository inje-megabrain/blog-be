package com.example.cb.controller;

import com.example.cb.dao.CommentDao;
import com.example.cb.model.CommentDto;
import com.example.cb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class CommentController {
    private CommentDao commentDao;
    private final CommentService commentService;

    @Autowired
    public CommentController (CommentService postService, CommentDao commentDao){
        this.commentService = postService;
        this.commentDao = commentDao;
    }

    //댓글 수정
    @PostMapping(value = "/post/{id}/comment")
    public void update(@PathVariable String id, @RequestBody CommentDto commentDto){
        commentService.updateComment(id, commentDto);
    }


}

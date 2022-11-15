package com.example.cb.controller;

import com.example.cb.dao.CommentDao;
import com.example.cb.entity.Comment;
import com.example.cb.model.CommentDto;
import com.example.cb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    //댓글 추가
    @PostMapping(value = "/post/{postid}/comment")
    public Comment add(@PathVariable String postid, @RequestBody CommentDto Dto){
        try{
            //내용이 빈칸일 때 예외처리
            if(Dto.getContent()=="")
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"내용을 작성하세요");

            return commentService.addComment(postid, Dto);

        }catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"잘못된 요청",e);
        }
    }

    //댓글 수정
    @PostMapping(value = "/post/{id}/comment")
    public void update(@PathVariable String id, @RequestBody CommentDto commentDto){
        commentService.updateComment(id, commentDto);
    }

    //대댓글
    @PostMapping(value = "/post/{postid}/bigcomment/{id}")
    public void BigComment(@PathVariable String postid,@PathVariable Long id, @RequestBody CommentDto Dto){

        try{
            if(commentDao.findByPostid(postid)==null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"해당 게시글이 존재하지 않습니다.");
            }

            commentService.addBigComment(postid, id, Dto);
        }catch(Exception e){
            System.out.println(e);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"잘못된 요청",e);
        }
    }

    //댓글 삭제
    @PostMapping(value = "/post/comment/delete/{id}")
    public CommentDto delete(@PathVariable String id){
        try{
            //id를 못찾을 때
            if(commentDao.findById(id)==null)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"해당하는 댓글이 없습니다.");
            return commentService.deleteComment(id);
        }catch(Exception e){
            System.out.println(e);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"잘못된 요청",e);

        }
    }
}

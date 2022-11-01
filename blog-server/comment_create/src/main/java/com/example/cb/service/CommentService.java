package com.example.cb.service;

import com.example.cb.dao.CommentDao;
import com.example.cb.entity.Comment;
import com.example.cb.model.CommentDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class CommentService {

    private final CommentDao commentDao;

    public CommentService(CommentDao commentDao){
        this.commentDao = commentDao;
    }

    //댓글 생성
    public void addComment(String postid, CommentDto commentDto){

        String parent = commentDto.getParent();
        /*
        if(postdao.findbyid(post_id)==null) parent = null;
        나중에 합치면 post_dao에 요청하기
         */
        CommentDto dto = CommentDto.builder()
                .id(commentDto.getId())
                .postid(postid)
                .author(commentDto.getAuthor())//토큰값으로 닉네임 읽어오기
                .content(commentDto.getContent())
                .lastEditedAt(null)
                .createAt(new Date(System.currentTimeMillis()))
                .isSecret(commentDto.isSecret())
                .likes(commentDto.getLikes())
                .parent(parent)
                .build();
        commentDao.save(new Comment(dto));
    }
}

package com.example.cb.service;

import com.example.cb.dao.CommentDao;
import com.example.cb.entity.Comment;
import com.example.cb.model.CommentDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class CommentService {

    private final CommentDao commentDao;

    public CommentService(CommentDao commentDao){
        this.commentDao = commentDao;
    }

    public void updateComment(String id, CommentDto commentDto){

        //예외처리 다시할 예정
        try{

            //id에 해당하는 값으로 dto 생성
            CommentDto dto = new CommentDto(commentDao.findById(id).get());

            //dao 업데이트
            commentDao.save(new Comment(dto.builder()
                    .id(Long.parseLong(id))
                    .postid(commentDto.getPostid())
                    .author(commentDto.getAuthor())
                    .content(commentDto.getContent())
                    .lastEditedAt(new Date(System.currentTimeMillis()))
                    .createAt(dto.getCreateAt())
                    .isSecret(commentDto.isSecret())
                    .parent(dto.getParent())
                    .build()));
        } catch(NoSuchElementException e){

        }

    }

}

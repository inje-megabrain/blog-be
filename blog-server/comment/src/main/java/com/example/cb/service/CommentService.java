package com.example.cb.service;

import com.example.cb.dao.CommentDao;
import com.example.cb.entity.Comment;
import com.example.cb.model.CommentDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

import static com.example.cb.entity.Comment.Commentfrom;
import static com.example.cb.entity.Comment.newCommentDto;

@Service
public class CommentService {

    private final CommentDao commentDao;

    public CommentService(CommentDao commentDao){
        this.commentDao = commentDao;
    }

    //댓글 생성
    public Comment addComment(String postid, CommentDto commentDto){
        /*
        if(postdao.findbyid(post_id)==null) parent = null;
        나중

        에 합치면 post_dao에 요청하기
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
                .parent(0L)
                .build();
        return commentDao.save(Commentfrom(dto));
    }

    //댓글수정
    public void updateComment(String id, CommentDto commentDto){

        //예외처리 다시할 예정
        try{

            //id에 해당하는 값으로 dto 생성
            CommentDto dto = new CommentDto(commentDao.findById(id).get());

            //dao 업데이트
            commentDao.save(Commentfrom(dto.builder()
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

    //대댓글 추가
    public void addBigComment(String postid, Long id, CommentDto commentDto){
        CommentDto dto = CommentDto.builder()
                //.id(commentDto.getId()) id키 자동지정
                .postid(postid)
                .author(commentDto.getAuthor())//토큰값으로 닉네임 읽어오기
                .content(commentDto.getContent())
                .lastEditedAt(null)
                .createAt(new Date(System.currentTimeMillis()))
                .isSecret(commentDto.isSecret())
                .likes(0L)
                .parent(id) //댓글의 id값을 받아서 대댓글로 추가
                .build();


        commentDao.save(Commentfrom(dto));
    }

    @Transactional
    public CommentDto deleteComment(String id){

        CommentDto dto = newCommentDto(commentDao.findById(id).get());
        commentDao.deleteByParent(Long.parseLong(id));//삭제되는 해당 id를 부모로 가지는 대댓글 전체 삭제
        commentDao.deleteById(Long.parseLong(id));
        return dto;

    }
}

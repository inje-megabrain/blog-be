package com.example.cb.dao;

import com.example.cb.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentDao extends CrudRepository<Comment, String> {


}

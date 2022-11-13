package com.example.cb.dao;

import com.example.cb.entity.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BlogDao extends CrudRepository<Blog, String> {
    Optional<Blog> findById(Long id);
    void deleteById(Long id);
}

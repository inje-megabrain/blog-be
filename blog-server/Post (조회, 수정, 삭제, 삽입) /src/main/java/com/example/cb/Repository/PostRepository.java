package com.example.cb.Repository;

import com.example.cb.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findBypostAuthor(String postAuthor); // postAuthor->작가를 찾는 find메소드 구현




    void deleteBypostAuthor(String postAuthor); //pustAuthor->작가를 delete하는 ㅔㅁ소드 구현


}


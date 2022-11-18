package com.example.cb.Controller;

import com.example.cb.DTO.PostDto;
import com.example.cb.Entity.Post;
import com.example.cb.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/search/{postAuthor}") //조회 기능
    public int search(@PathVariable String postAuthor, HttpServletResponse response){
        return postService.search(postAuthor);
    }

    @PostMapping("/create") //삽입 & 수정 기능
    public Post create(@ModelAttribute PostDto postDto, HttpServletResponse response){
        //postService.update(postDto);
        Optional <Post> post  = Optional.ofNullable(postService.save(postDto));
        return post.get();
    }
    @GetMapping("/delete/{postAuthor}") //삭제 기능
    public String delete(@PathVariable String postAuthor, HttpServletResponse response){
        return "";
    }
}

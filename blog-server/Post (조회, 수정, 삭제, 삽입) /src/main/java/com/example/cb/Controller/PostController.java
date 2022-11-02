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
    public List<Post> search(@PathVariable String postAuthor, HttpServletResponse response){
        try{
            List <Post> post = postService.search(postAuthor);
            if(!post.isEmpty()) { response.setStatus(HttpServletResponse.SC_OK);
                return post;
            }
            else { response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return null;
            }
        }
        catch(Exception e){ response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
    }

    @PostMapping("/create") //삽입 & 수정 기능
    public Post create(@ModelAttribute PostDto postDto, HttpServletResponse response){
        //postService.update(postDto);
        try{
            Optional <Post> post  = Optional.ofNullable(postService.save(postDto));
            if(post.isPresent()){response.setStatus(HttpServletResponse.SC_OK);
                return post.get();
            }
            else { response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return null;
            }
        }catch (Exception e){ response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
    }
    @GetMapping("/delete/{postAuthor}") //삭제 기능
    public void delete(@PathVariable String postAuthor, HttpServletResponse response){
        try{
            if(postService.delete(postAuthor)) response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        catch (Exception e){
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}

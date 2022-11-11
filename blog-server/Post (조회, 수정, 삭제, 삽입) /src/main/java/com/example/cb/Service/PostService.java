package com.example.cb.Service;

import com.example.cb.DTO.PostDto;
import com.example.cb.Entity.Post;
import com.example.cb.Mapper.PostMapper;
import com.example.cb.Repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepository;
    PostMapper postMapper;


    public PostService(PostMapper postMapper){ this.postMapper=postMapper; }

    //GetMapping에서 조회를 담당하는 메소드
    public int search(String name){
        List<Post> post = postRepository.findBypostAuthor(name);
        HttpServletResponse response = null;
        try{
            if(!post.isEmpty())  response.setStatus(HttpServletResponse.SC_OK);
            else  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        catch(Exception e){ response.setStatus(HttpServletResponse.SC_BAD_REQUEST);}
        return response.getStatus();
    }

    //PostMapping에서 저장을 담당하는 메소드
    public Post save(PostDto postDto){
        HttpServletResponse response=null;
        Post post = postMapper.toEntity(postDto);
        postRepository.save(post);
        return post;
    }


    //GetMapping에서 delete를 담당하는 메소드
    public String delete(String name) {
        HttpServletResponse response = null;
        if(postRepository.findBypostAuthor(name)==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return "실패";
        } //postAuthor를 찾는 메소드
        else { postRepository.deleteBypostAuthor(name);
            response.setStatus(HttpServletResponse.SC_OK);
            return "성공";
        }
    }
}

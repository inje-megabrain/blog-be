package com.example.cb.Service;

import com.example.cb.DTO.PostDto;
import com.example.cb.Entity.Post;
import com.example.cb.Mapper.PostMapper;
import com.example.cb.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    PostMapper postMapper;


    public PostService(PostMapper postMapper){ this.postMapper=postMapper; }

    //GetMapping에서 조회를 담당하는 메소드
    public List<Post> search(String name){ return postRepository.findBypostAuthor(name);}

    //PostMapping에서 저장을 담당하는 메소드
    public Post save(PostDto postDto){
        Post post = postMapper.toEntity(postDto);
        return postRepository.save(post);
    }


    //GetMapping에서 delete를 담당하는 메소드
    public boolean delete(String name) {
        if(postRepository.findBypostAuthor(name)==null){ return false;} //postAuthor를 찾는 메소드
        else { postRepository.deleteBypostAuthor(name);
            return true;
        }
    }
}

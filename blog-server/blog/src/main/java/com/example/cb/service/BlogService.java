package com.example.cb.service;

import com.example.cb.dao.BlogDao;
import com.example.cb.entity.Blog;
import com.example.cb.model.BlogDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import static com.example.cb.entity.Blog.Bolgfrom;

@Service
public class BlogService {

    private final BlogDao blogDao;

    public BlogService(BlogDao blogDao){
        this.blogDao = blogDao;
    }

    //블로그 생성
    public Blog addBlog(BlogDto blogDto){
        BlogDto dto = BlogDto.builder()
                .id(blogDto.getId())
                .owner(blogDto.getOwner())
                .title(blogDto.getTitle())
                .createAt(new Date(System.currentTimeMillis()))
                .removeAt(blogDto.getRemoveAt())
                .build();
        return blogDao.save(Bolgfrom(dto));
        
    }

    //블로그 수정
    public Blog editTitle(String id,String title){
            BlogDto blogDto = new BlogDto(blogDao.findById(Long.parseLong(id)).get());

            return blogDao.save(Bolgfrom(blogDto.builder()
                    .id(Long.parseLong(id))
                    .owner(blogDto.getOwner())
                    .title(title)
                    .createAt(blogDto.getCreateAt())
                    .removeAt(blogDto.getRemoveAt())
                    .build()));

    }
    //블로그 삭제(토큰값으로 해서 나중에 삭제되게 한다했던것 같은데 얘기해봐야할듯?)
    @Transactional
    public Blog blogDelete(String id){
        Blog blog = blogDao.findById(Long.parseLong(id)).get();
        blogDao.deleteById(Long.parseLong(id));
        return blog;
    }


}

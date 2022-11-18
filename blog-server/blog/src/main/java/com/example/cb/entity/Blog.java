package com.example.cb.entity;

import com.example.cb.model.BlogDto;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@Entity
@Table(name="blog")
public class Blog {

    @Id
    @Column(name = "blog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //글이름(글id)
    @Column(name = "owner")
    private String owner;

    @Column(name = "title")
    private String title;

    @Column(name = "createAt")
    private Date createAt;

    @Column(name = "removeAt")
    private Date removeAt;

    public Blog() {

    }

    public Blog(Long id, String owner, String title, Date createAt, Date removeAt) {
        this.id = id;
        this.owner = owner;
        this.title = title;
        this.createAt = createAt;
        this.removeAt = removeAt;
    }

    private Blog(BlogDto blogDto){
        id = blogDto.getId();
        owner = blogDto.getOwner();
        title = blogDto.getTitle();
        createAt = blogDto.getCreateAt();
        removeAt = blogDto.getRemoveAt();
    }


    public static Blog Bolgfrom(BlogDto dto){
        return new Blog(dto);
    }
}

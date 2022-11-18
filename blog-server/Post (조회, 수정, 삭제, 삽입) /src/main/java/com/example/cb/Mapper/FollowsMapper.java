package com.example.cb.Mapper;

import com.example.cb.DTO.FollowsDto;
import com.example.cb.DTO.PostDto;
import com.example.cb.Entity.Follows;
import com.example.cb.Entity.Post;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring") //mapstruct 인식
public interface FollowsMapper extends EntityMapper<FollowsDto, Follows>{
}


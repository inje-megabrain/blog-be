package com.example.cb.Mapper;

public interface EntityMapper <D, E>{
    E toEntity (D dto); //Mapper에서 DTO를 좀 더 쉽게 Entity로 바꿔줍니다
    D toDto (E entity); //Mapper에서 Entity를 좀 더 쉽게 DTO로 바꿔줍니다
}

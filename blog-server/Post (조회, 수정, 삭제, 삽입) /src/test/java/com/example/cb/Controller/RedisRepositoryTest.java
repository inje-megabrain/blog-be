package com.example.cb.Controller;

import com.example.cb.Entity.Follows;
import com.example.cb.Repository.FollowsRedisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
public class RedisRepositoryTest {

    @Autowired
    private FollowsRedisRepository followsRedisRepository;

    @Test
    void test(){
        Follows follows = new Follows();
        follows.setFollowFrom("이성현");
        follows.setFollowTo("문준호");
        followsRedisRepository.save(follows);

        // `keyspace:id` 값을 가져옴
        followsRedisRepository.findById(follows.getFollowFrom());

        // Person Entity 의 @RedisHash 에 정의되어 있는 keyspace (people) 에 속한 키의 갯수를 구함
        followsRedisRepository.count();

    }
}



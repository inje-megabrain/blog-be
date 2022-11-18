package com.example.cb.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Entity
@Setter
@RedisHash(value = "follower", timeToLive = 30)
public class Follows {

    @org.springframework.data.annotation.Id
    @Id
    @Column(name = "follow_from")
    private String followFrom;
    
    @Column(name = "follow_to")
    private String followTo;

    @Column(name = "follow_time")
    private String followTime;

    public String getFollowTime() {
        return followTime;
    }

    public void setFollowTime(String followTime) {
        this.followTime = followTime;
    }

    public void setFollowFrom(String followFrom) {
        this.followFrom = followFrom;
    }

    public void setFollowTo(String followTo) {
        this.followTo = followTo;
    }

    public String getFollowFrom() {
        return followFrom;
    }

    public String getFollowTo() {
        return followTo;
    }
}

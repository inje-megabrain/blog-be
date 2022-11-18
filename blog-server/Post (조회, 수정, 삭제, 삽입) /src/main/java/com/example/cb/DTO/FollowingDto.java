package com.example.cb.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class FollowingDto {
    private String followingFrom;

    private String followingTo;

    private String followingTime;

    public String getFollowingTime() {
        return followingTime;
    }

    public void setFollowingTime(String followingTime) {
        this.followingTime = followingTime;
    }

    public void setFollowingFrom(String followingFrom) {
        this.followingFrom = followingFrom;
    }



    public void setFollowingTo(String followingTo) {
        this.followingTo = followingTo;
    }
    public String getFollowingFrom() {
        return followingFrom;
    }

    public String getFollowingTo() {
        return followingTo;
    }
}

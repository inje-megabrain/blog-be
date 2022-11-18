package com.example.cb.DTO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

public class FollowsDto{




    private String followFrom;

    private String followTo;

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
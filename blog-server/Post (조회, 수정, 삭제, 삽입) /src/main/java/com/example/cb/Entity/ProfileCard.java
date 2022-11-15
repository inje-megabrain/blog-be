package com.example.cb.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class ProfileCard {
    @Id
    @Column(name = "Id")
    private String card_id;

    @Column(name = "image")
    private String card_image;

    public ProfileCard(){}

    public ProfileCard(String card_id, String card_image) {
        this.card_id = card_id;
        this.card_image = card_image;
    }
}

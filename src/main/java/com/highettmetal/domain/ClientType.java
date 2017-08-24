package com.highettmetal.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.highettmetal.jsonviews.Views;

import javax.persistence.*;

/**
 * Created by rodmccutcheon on 16/7/17.
 */
@Entity
@Table(name = "clienttypes")
public class ClientType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String level;

    @JsonView(Views.Client.class)
    private int discount;

    private int position;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ClientType{" +
                "id=" + id +
                ", level='" + level + '\'' +
                ", discount=" + discount +
                ", position=" + position +
                '}';
    }
}

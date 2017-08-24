package com.highettmetal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by rodmccutcheon on 16/7/17.
 */
@Entity
@Table(name = "bintypes")
public class BinType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    @NotNull
    @JsonProperty("bin_name")
    private String name;

    @NotNull
    @JsonProperty("bin_size")
    private String size;

    @JsonProperty("bin_image")
    private String imagePath;

    @JsonIgnore
    private int position;

    public BinType() { }

    public BinType(String name) {
        this.name = name;
    }

    public BinType(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

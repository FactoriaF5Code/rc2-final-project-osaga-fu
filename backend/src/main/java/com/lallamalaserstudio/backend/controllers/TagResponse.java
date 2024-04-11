package com.lallamalaserstudio.backend.controllers;

import com.lallamalaserstudio.backend.persistence.Tag;

public class TagResponse {

    private Long id;
    private String name;
    private String size;
    private Double price;
    private String photoUrl;
    private String description;

    public TagResponse(Long id, String name, String size, Double price, String photoUrl, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.photoUrl = photoUrl;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public static TagResponse from(Tag tag) {
        return new TagResponse(tag.getId(), tag.getName(), tag.getSize(), tag.getPrice(), tag.getPhotoUrl(), tag.getDescription());
    }
}

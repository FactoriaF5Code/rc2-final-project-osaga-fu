package com.lallamalaserstudio.backend.controllers;

public class TagResponse {

    private Long id;
    private String name;
    private String size;
    private Double price;
    private String photoUrl;

    public TagResponse(Long id, String name, String size, Double price, String photoUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.photoUrl = photoUrl;
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
}

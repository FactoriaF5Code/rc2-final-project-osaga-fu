package com.lallamalaserstudio.backend.controllers;

public class TagResponse {

    private String name;
    private Double price;
    private String size;

    public TagResponse(String name, Double price, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
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
    
}

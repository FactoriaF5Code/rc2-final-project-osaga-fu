package com.lallamalaserstudio.backend.controllers.cart;

public class CartRequest {

    private Long tagId;
    private String text;
    private String color;
    private String typography;
    private Integer quantity;

    public CartRequest(String text, String color, String typography, Integer quantity, Long tagId) {
        this.text = text;
        this.color = color;
        this.typography = typography;
        this.quantity = quantity;
        this.tagId = tagId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTypography() {
        return typography;
    }

    public void setTypography(String typography) {
        this.typography = typography;
    }


    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}

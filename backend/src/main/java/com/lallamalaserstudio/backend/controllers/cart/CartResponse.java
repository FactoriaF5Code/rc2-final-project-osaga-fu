package com.lallamalaserstudio.backend.controllers.cart;

import com.lallamalaserstudio.backend.persistence.cart.Cart;
import com.lallamalaserstudio.backend.persistence.tag.Tag;

public class CartResponse {

    private Long id;
    private Integer quantity;
    private String text;
    private String color;
    private String typography;
    private String tagName;
    private Long tagId;
    private Double tagPrice;
    private String photoUrl;


    public CartResponse(Long id, Integer quantity, String text, String color, String typography, String tagName, Long tagId, Double tagPrice, String photoUrl) {
        this.id = id;
        this.quantity = quantity;
        this.text = text;
        this.color = color;
        this.typography = typography;
        this.tagName = tagName;
        this.tagId = tagId;
        this.tagPrice = tagPrice;
        this.photoUrl = photoUrl;
    }


    public String getTypography() {
        return typography;
    }

    public void setTypography(String typography) {
        this.typography = typography;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static CartResponse fromCart(Cart cart) {
        return new CartResponse(cart.getId(), cart.getQuantity(), cart.getText(), cart.getColor(), cart.getTypography(), cart.getTag().getName(), cart.getTag().getId(), cart.getTag().getPrice(), cart.getTag().getPhotoUrl());
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Double getTagPrice() {
        return tagPrice;
    }

    public void setTagPrice(Double tagPrice) {
        this.tagPrice = tagPrice;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}

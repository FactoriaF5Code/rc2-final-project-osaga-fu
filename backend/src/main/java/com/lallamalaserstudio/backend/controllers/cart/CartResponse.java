package com.lallamalaserstudio.backend.controllers.cart;

public class CartResponse {

    private Long id;
    private Integer quantity;
    private String text;
    private String color;
    private String typography;

    public CartResponse(Long id, Integer quantity, String text, String color, String typography) {
        this.id = id;
        this.quantity = quantity;
        this.text = text;
        this.color = color;
        this.typography = typography;
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
}

package com.lallamalaserstudio.backend.persistence.tag;

import com.lallamalaserstudio.backend.persistence.cart.Cart;
import jakarta.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String size;
    private String photoUrl;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_cart")
    private Cart cart;

    public Tag(Long id, String name, Double price, String size, String photoUrl, String description, Cart cart) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.photoUrl = photoUrl;
        this.description = description;
        this.cart = cart;
    }

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

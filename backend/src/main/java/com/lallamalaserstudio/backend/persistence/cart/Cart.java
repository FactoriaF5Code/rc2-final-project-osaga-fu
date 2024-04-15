package com.lallamalaserstudio.backend.persistence.cart;

import com.lallamalaserstudio.backend.persistence.tag.Tag;
import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_tag")
    private Tag tag;

    private Integer quantity;
    private String text;
    private String color;
    private String typography;

    public Cart(Long id, Integer quantity, String text, String color, String typography){
        this.id = id;
        this.quantity = quantity;
        this.text = text;
        this.color = color;
        this.typography = typography;
    }

    public Cart(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}

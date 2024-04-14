package com.lallamalaserstudio.backend.persistence.cart;

import java.util.ArrayList;
import java.util.List;

import com.lallamalaserstudio.backend.persistence.tag.Tag;
import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart")
    private List<Tag> tag;

    private String text;
    private String color;
    private String typography;

    public Cart(Long id, String text, String color, String typography){
        this.id = id;
        this.text = text;
        this.color = color;
        this.typography = typography;
        this.tag = new ArrayList<Tag>();
    }

    public Cart(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
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
}

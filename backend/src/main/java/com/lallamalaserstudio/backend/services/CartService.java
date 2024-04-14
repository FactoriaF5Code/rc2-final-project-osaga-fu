package com.lallamalaserstudio.backend.services;

import com.lallamalaserstudio.backend.controllers.cart.CartRequest;
import com.lallamalaserstudio.backend.controllers.cart.CartResponse;
import com.lallamalaserstudio.backend.persistence.cart.Cart;
import com.lallamalaserstudio.backend.persistence.cart.CartRepository;
import com.lallamalaserstudio.backend.persistence.tag.Tag;
import com.lallamalaserstudio.backend.persistence.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final TagRepository tagRepository;

    public CartService(@Autowired CartRepository cartRepository, TagRepository tagRepository) {
        this.cartRepository = cartRepository;
        this.tagRepository = tagRepository;
    }

    public List<CartResponse> getAllCarts() {
        return cartRepository.findAll().stream().map(CartResponse::fromCart).collect(Collectors.toList());
    }

    public CartResponse addCart(CartRequest cartRequest) {
        Tag tag = tagRepository.findById(cartRequest.getTagId()).orElse(null);

        if (tag == null) {
            throw new RuntimeException("Tag with ID " + cartRequest.getTagId() + " not found");
        }

        Cart cart = new Cart();
        cart.setTag(tag);
        cart.setQuantity(cartRequest.getQuantity());
        cart.setText(cartRequest.getText());
        cart.setColor(cartRequest.getColor());
        cart.setTypography(cartRequest.getTypography());

        Cart savedCart = cartRepository.save(cart);

        return CartResponse.fromCart(savedCart);

    }

    public void deleteCart(Long cartId) {
        if (!cartRepository.existsById(cartId)) {
            throw new RuntimeException("Cart with ID " + cartId + " not found");
        }
        cartRepository.deleteById(cartId);
    }

    public void updateCart(Long cartId, CartRequest cartRequest) {
        Cart existingCart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart with ID " + cartId + " not found"));

        Tag tag = tagRepository.findById(cartRequest.getTagId())
                .orElseThrow(() -> new RuntimeException("Tag with ID " + cartRequest.getTagId() + " not found"));

        existingCart.setTag(tag);
        existingCart.setQuantity(cartRequest.getQuantity());
        existingCart.setText(cartRequest.getText());
        existingCart.setColor(cartRequest.getColor());
        existingCart.setTypography(cartRequest.getTypography());

        cartRepository.save(existingCart);
    }


}

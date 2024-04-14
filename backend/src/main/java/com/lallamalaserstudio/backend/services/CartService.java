package com.lallamalaserstudio.backend.services;

import com.lallamalaserstudio.backend.controllers.cart.CartResponse;
import com.lallamalaserstudio.backend.persistence.cart.Cart;
import com.lallamalaserstudio.backend.persistence.cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(@Autowired CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<CartResponse> getAllCarts() {
        return cartRepository.findAll().stream().map(CartResponse::fromCart).collect(Collectors.toList());
    }

    public CartResponse addCart(Cart cart) {
        return CartResponse.fromCart(cartRepository.save(cart));
    }
}

package com.lallamalaserstudio.backend.services;

import com.lallamalaserstudio.backend.controllers.cart.CartRequest;
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

    public CartResponse addCart(CartRequest cartRequest) {
        Cart cart = new Cart(cartRequest.getCartId(),cartRequest.getQuantity(), cartRequest.getText(), cartRequest.getColor(), cartRequest.getTypography());
        Cart savedCart = cartRepository.save(cart);
        return new CartResponse(savedCart.getId(), savedCart.getQuantity(), savedCart.getText(), savedCart.getColor(), savedCart.getTypography());

    }


}

package com.lallamalaserstudio.backend.controllers.cart;

import com.lallamalaserstudio.backend.persistence.cart.Cart;
import com.lallamalaserstudio.backend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("http://localhost:5173")
public class CartController {

    private final CartService cartService;

    public CartController(@Autowired CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartResponse> getAll() {
        return cartService.getAllCarts();
    }

    @PostMapping
    public CartResponse add(@RequestBody CartRequest cartRequest) {
        return cartService.addCart(cartRequest);
    }
}

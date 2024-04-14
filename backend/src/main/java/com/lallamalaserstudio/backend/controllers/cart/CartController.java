package com.lallamalaserstudio.backend.controllers.cart;

import com.lallamalaserstudio.backend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("http://localhost:5173")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<CartResponse> getAll() {
        return cartService.getAllCarts();
    }
}

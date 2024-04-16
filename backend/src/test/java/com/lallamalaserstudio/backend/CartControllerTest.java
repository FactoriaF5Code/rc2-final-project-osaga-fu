package com.lallamalaserstudio.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lallamalaserstudio.backend.controllers.cart.CartRequest;
import com.lallamalaserstudio.backend.controllers.cart.CartResponse;
import com.lallamalaserstudio.backend.services.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CartService cartService;

    @Test
    public void testGetAllCarts() throws Exception {

        CartResponse cart1 = new CartResponse(1L, 1, "Polarizer", "Blue", "Arial", "Filter Tag", 2L, 1.8, "photo");
        CartResponse cart2 = new CartResponse(2L, 1, "ND12", "Yellow", "Courier New", "Filter Tag", 2L, 1.8, "photo2");

        List<CartResponse> cartList = Arrays.asList(cart1, cart2);

        when(cartService.getAllCarts()).thenReturn(cartList);

        mvc.perform(get("/api/cart"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].text").value("Polarizer"))
                .andExpect(jsonPath("$[0].color").value("Blue"))
                .andExpect(jsonPath("$[0].typography").value("Arial"))
                .andExpect(jsonPath("$[0].tagName").value("Filter Tag"))
                .andExpect(jsonPath("$[0].tagId").value(2))
                .andExpect(jsonPath("$[0].tagPrice").value(1.8))
                .andExpect(jsonPath("$[0].photoUrl").value("photo"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].text").value("ND12"))
                .andExpect(jsonPath("$[1].color").value("Yellow"))
                .andExpect(jsonPath("$[1].typography").value("Courier New"))
                .andExpect(jsonPath("$[1].tagId").value(2))
                .andExpect(jsonPath("$[1].tagPrice").value(1.8))
                .andExpect(jsonPath("$[1].photoUrl").value("photo2"));

    }

    @Test
    public void testAddCart() throws Exception {

        CartRequest cartRequest = new CartRequest("Texto", "Green", "Roboto", 1, 1L);

        CartResponse cartResponse = new CartResponse(1L, 1, "Texto", "Green", "Roboto", "Focus Star", 1L, 7.0, "photo");
        when(cartService.addCart(any(CartRequest.class))).thenReturn(cartResponse);

        String jsonRequest = objectMapper.writeValueAsString(cartRequest);

        mvc.perform(post("/api/cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.text").value("Texto"))
                .andExpect(jsonPath("$.color").value("Green"))
                .andExpect(jsonPath("$.typography").value("Roboto"))
                .andExpect(jsonPath("$.tagName").value("Focus Star"))
                .andExpect(jsonPath("$.tagId").value(1))
                .andExpect(jsonPath("$.tagPrice").value(7.0))
                .andExpect(jsonPath("$.photoUrl").value("photo"));
    }
}

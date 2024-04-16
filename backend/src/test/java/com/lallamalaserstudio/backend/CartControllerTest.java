package com.lallamalaserstudio.backend;

import com.lallamalaserstudio.backend.controllers.cart.CartResponse;
import com.lallamalaserstudio.backend.services.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {

    @Autowired
    private MockMvc mvc;

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
}

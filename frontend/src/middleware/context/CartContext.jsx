import React, { createContext, useContext, useState } from "react";
import { CartService } from "../../services/CartService";

const CartContext = createContext();

export const CartProvider = ({ children }) => {
  const [cart, setCart] = useState([]);

  const cartService = new CartService();

  const fetchCart = async () => {
    try {
      const carts = await cartService.getAllCarts();
      setCart(carts);
    } catch (error) {
      console.error("Error fetching cart:", error);
    }
  };

  const addToCart = async (cartData) => {
    try {
      const newCart = await cartService.addToCart(cartData);
      setCart([...cart, newCart]);
    } catch (error) {
      console.error("Error adding to cart:", error);
    }
  };

  const deleteCart = async (cartId) => {
    try {
      await cartService.deleteCart(cartId);
      const updatedCartList = cart.filter((item) => item.id !== cartId);
      setCart(updatedCartList);
    } catch (error) {
      console.error("Error deleting cart:", error);
    }
  };

  return (
    <CartContext.Provider
      value={{
        cart,
        fetchCart,
        addToCart,
        deleteCart,
      }}
    >
      {children}
    </CartContext.Provider>
  );
};

export const useCart = () => useContext(CartContext);

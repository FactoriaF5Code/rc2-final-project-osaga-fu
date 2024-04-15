import React, { createContext, useContext, useState } from "react";
import { CartService } from "../../services/CartService";

const CartContext = createContext();

export const CartProvider = ({ children }) => {
  const [cart, setCart] = useState([]);
  const [showModal, setShowModal] = useState(false);

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

  const updateCart = async (cartId, cartData) => {
    try {
      const updatedCart = await cartService.updateCart(cartId, cartData);
      const updatedCartList = cart.map((item) =>
        item.id === cartId ? updatedCart : item
      );
      setCart(updatedCartList);
    } catch (error) {
      console.error("Error updating cart:", error);
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

  const openModal = () => {
    setShowModal(true);
  };

  const closeModal = () => {
    setShowModal(false);
  };

  return (
    <CartContext.Provider
      value={{
        cart,
        fetchCart,
        addToCart,
        updateCart,
        deleteCart,
        openModal,
        closeModal,
        showModal
      }}
    >
      {children}
    </CartContext.Provider>
  );
};

export const useCart = () => useContext(CartContext);

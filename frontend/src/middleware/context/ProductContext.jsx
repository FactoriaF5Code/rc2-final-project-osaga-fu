import { ProductService } from "../../services/ProductService";
import { createContext, useState } from "react";

const ProductContext = createContext();

export const ProductProvider = ({ children }) => {

  const [showModal, setShowModal] = useState(false);
  const [cartItems, setCartItems] = useState(0);

  const showProducts = async () => {
    const productService = new ProductService();
    return productService.showTags();
  };

  const showProductById = async (id) => {
    const productService = new ProductService();
    return productService.showTagById(id);
  };

  function handleCustomButtonClick() {
    setShowModal(true);
  }

  function closeModal() {
    setShowModal(false);
  }

  const addToCart = () => {
    setCartItems(cartItems+1);
  }

  const cartProducts = () => cartItems;

  const value = {
    showProducts,
    showProductById,
    handleCustomButtonClick,
    closeModal,
    showModal,
    setShowModal,
    addToCart,
    cartProducts
  
  };

  return (
    <ProductContext.Provider value={value}>{children}</ProductContext.Provider>
  );
};

export { ProductContext };

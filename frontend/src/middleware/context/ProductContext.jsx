import { ProductService } from "../../services/ProductService";
import { createContext, useState } from "react";

const ProductContext = createContext();

export const ProductProvider = ({ children }) => {

  const [showModal, setShowModal] = useState(false);

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

  const value = {
    showProducts,
    showProductById,
    handleCustomButtonClick,
    closeModal,
    showModal,
    setShowModal
  
  };

  return (
    <ProductContext.Provider value={value}>{children}</ProductContext.Provider>
  );
};

export { ProductContext };

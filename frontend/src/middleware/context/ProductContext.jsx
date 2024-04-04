import { ProductService } from "../../services/ProductService";
import { createContext} from "react";

const ProductContext = createContext();

export const ProductProvider = ({ children }) => {
    
    const showProducts = async () => {

        const productService = new ProductService();
        return productService.showTags();
    } 

    const value = {
        showProducts
    }

    return (
        <ProductContext.Provider value={value}>
            {children}
        </ProductContext.Provider>
    );
}

export { ProductContext };
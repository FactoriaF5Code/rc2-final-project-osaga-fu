import "./App.css";
import { CartProvider } from "./middleware/context/CartContext";
import { ProductProvider } from "./middleware/context/ProductContext";
import AppRouter from "./middleware/router/AppRouter";

function App() {
  return (
    <CartProvider>
      <ProductProvider>
        <AppRouter />
      </ProductProvider>
    </CartProvider>
  );
}

export default App;

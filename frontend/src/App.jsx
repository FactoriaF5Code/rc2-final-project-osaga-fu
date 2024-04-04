import "./App.css";
import { ProductProvider } from "./middleware/context/ProductContext";
import AppRouter from "./middleware/router/AppRouter";

function App() {
  return (
    <ProductProvider>
      <AppRouter />
    </ProductProvider>
  );
}

export default App;

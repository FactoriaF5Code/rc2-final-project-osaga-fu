import { BrowserRouter, Routes, Route } from "react-router-dom";
import ProductDetail from "../../presentation/components/ProductDetail/ProductDetail";
import Landing from "../../presentation/pages/Landing";
import Home from "../../presentation/pages/Home";
import Cart from "../../presentation/components/Cart/Cart";

export default function AppRouter() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />}>
          <Route index element={<Landing />} />
          <Route path="products/:id" element={<ProductDetail />} />
          <Route path="cart" element={<Cart />}/>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

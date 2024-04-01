import { BrowserRouter, Routes, Route } from "react-router-dom";
import ProductDetail from "../../presentation/components/ProductDetail/ProductDetail";
import ProductList from "../../presentation/components/ProductList/ProductList";
import Home from "../../presentation/pages/Home";

export default function AppRouter() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />}>
          <Route path="" element={<ProductList />} />
          <Route path="products/:id" element={<ProductDetail />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

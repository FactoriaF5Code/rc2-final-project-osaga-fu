import { BrowserRouter, Routes, Route } from "react-router-dom";
import ProductDetail from "../../presentation/components/ProductDetail/ProductDetail";
import Landing from "../../presentation/pages/Landing";
import Home from "../../presentation/pages/Home";

export default function AppRouter() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />}>
          <Route index element={<Landing />} />
          <Route path="products/:id" element={<ProductDetail />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

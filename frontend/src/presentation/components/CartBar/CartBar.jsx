import "./CartBar.css";
import Cart from "../../assets/images/Cart.png";
import { useContext } from "react";
import { ProductContext } from "../../../middleware/context/ProductContext.jsx";
import { Link } from "react-router-dom";

export default function CartBar() {
  const { cartProducts } = useContext(ProductContext);

  return (
    <section className="cart-bar">
      <Link to="/cart">
        <img className="cart-logo" src={Cart} alt="Cart logo" />
      </Link>
      {cartProducts() > 0 && (
        <span className="cart-counter" >{cartProducts()}</span>
      )}
    </section>
  );
}

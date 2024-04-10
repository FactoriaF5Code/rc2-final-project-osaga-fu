import "./CartBar.css";
import Cart from "../../assets/images/Cart.png";

export default function CartBar() {
  return (
    <section className="cart-bar">
      <img className="cart-logo" src={Cart} alt="Cart logo" />
    </section>
  );
}

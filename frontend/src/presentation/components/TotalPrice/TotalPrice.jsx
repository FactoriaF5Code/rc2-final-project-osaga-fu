import "./TotalPrice.css";
import { useCart } from "../../../middleware/context/CartContext";
import { useEffect } from "react";

export default function TotalPrice() {

  const { cart, calculateTotalPrice, totalPrice } = useCart();

  useEffect(() => {
    calculateTotalPrice();
  }, [cart, calculateTotalPrice]);

  return (
    <section className="total-price-wrapper">
      <article className="total-price-container">
        <h5>Total Price:</h5>
        <div>{totalPrice} €</div>
      </article>
    </section>
  );
}

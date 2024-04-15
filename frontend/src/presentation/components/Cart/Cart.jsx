import "./Cart.css";
import picture from "../../assets/images/_DSC0148-1.jpg";
import { useCart } from "../../../middleware/context/CartContext";
import { useEffect } from "react";

export default function Cart() {
  const { cart, fetchCart } = useCart();

  useEffect(() => {
    fetchCart();
  }, []);

  return (
    <main className="back-ground">
      <section className="list-container">
        <h3 className="list-title">Cart</h3>
        <section className="cart-wrapper">
          {cart.map((cart) => (
            <article key={cart.id}>
              <div className="cart-image-container">
                <img className="cart-image" src={cart.photoUrl} alt={cart.tagName} />
              </div>
              <span className="cart-text">
                <h5>{cart.tagName}</h5>
                <h6>{cart.text}</h6>
                <h6>{cart.color}</h6>
                <h6>{cart.typography}</h6>
              </span>
              <span className="right-section-card">
                <h5>Quantity</h5>
                <div>{cart.quantity}</div>
                <h5>Price</h5>
                <div>{cart.tagPrice}€</div>
              </span>
              <div className="right-section-card">
                <button className="modify-button">Modify</button>
                <button className="delete-button">Delete</button>
              </div>
            </article>
          ))}
        </section>
      </section>
    </main>
  );
}

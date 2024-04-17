import "./Cart.css";
import { useCart } from "../../../middleware/context/CartContext";
import { useEffect } from "react";
import { Link } from "react-router-dom";

export default function Cart() {
  const { cart, fetchCart, deleteCart } = useCart();

  const handleDelete = (cartId) => {
    deleteCart(cartId);
  };

  useEffect(() => {
    fetchCart();
  }, []);

  return (
    <main className="back-ground cart">
      <section className="list-container">
        <h3 className="list-title">Cart</h3>
        <section className="cart-wrapper">
          {cart.length == 0 && (
            <h4 className="no-elements">No hay elementos en la cesta</h4>
          )}
          {cart.map((cart) => (
            <article key={cart.id}>
              <Link to={`/products/${cart.tagId}`}>
                <div className="cart-image-container">
                  <img
                    className="cart-image"
                    src={cart.photoUrl}
                    alt={cart.tagName}
                  />
                </div>
              </Link>
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
                <button
                  className="delete-button"
                  onClick={() => handleDelete(cart.id)}
                >
                  Delete
                </button>
              </span>
            </article>
          ))}
        </section>
      </section>
    </main>
  );
}

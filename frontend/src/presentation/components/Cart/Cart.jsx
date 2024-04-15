import "./Cart.css";
import picture from "../../assets/images/_DSC0148-1.jpg";

export default function Cart() {
  return (
    <main className="back-ground">
      <section className="list-container">
        <h3 className="list-title">Cart</h3>
        <section className="cart-wrapper">
          <article>
            <div className="cart-image-container">
              <img className="cart-image" src={picture} alt="" />
            </div>
            <span className="cart-text">
              <h5>nombre</h5>
              <h6>texto</h6>
              <h6>color</h6>
              <h6>typography</h6>
            </span>
            <span className="right-section-card">
              <h5>Quantity</h5>
              <div>cantidad</div>
              <h5>Price</h5>
              <div>precio</div>
            </span>
            <div className="right-section-card">
              <button className="modify-button">Modify</button>
              <button className="delete-button">Delete</button>
            </div>
          </article>
        </section>
      </section>
    </main>
  );
}

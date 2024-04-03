import "./ProductList.css";
import Image from "../../assets/images/_DSC0148-1.jpg";

export default function ProductList() {
  return (
    <section className="list-container">
      <h3 className="list-title">Products</h3>
      <section className="products-wrapper">
        <article className="product-container">
          <div className="product-image-container">
            <img className="product-image" src={Image} alt="" />
          </div>
          <span className="product-info">
            <h5 className="info-title">Focus Star</h5>
            <h4 className="info-price">10€</h4>
          </span>
        </article>
      </section>
    </section>
  );
}

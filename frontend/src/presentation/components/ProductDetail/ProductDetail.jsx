import "./ProductDetail.css";
import Image from "../../assets/images/_DSC0148-1.jpg";

export default function ProductDetail() {
  return (
    <main>
      <section className="detail-container">
        <div className="photo-container">
          <img className="detail-photo" src={Image} alt="" />
        </div>
        <aside className="detail-info">
          <span>
            <h3 className="text-title">Focus Star</h3>
            <p className="text-description">
              Custom your own focus star so you'll never lose it again.
            </p>
            <h4 className="detail-price">10€</h4>
          </span>
          <button className="back-button">Back</button>
        </aside>
      </section>
    </main>
  );
}

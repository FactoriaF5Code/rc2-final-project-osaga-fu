import "./ProductDetail.css";
import { Link, useParams } from "react-router-dom";
import { useContext, useEffect, useState } from "react";
import { ProductContext } from "../../../middleware/context/ProductContext";

export default function ProductDetail() {
  const { id } = useParams();

  const [product, setProduct] = useState(null);

  const { showProductById } = useContext(ProductContext);

  useEffect(() => {
    const fetchProduct = async () => {
      const response = await showProductById(id);
      setProduct(response);
      console.log(id);
    };

    fetchProduct();
  }, [id]);

  if (!product) {
    return <div className="loading"></div>;
  }

  return (
    <main>
      <section className="detail-container">
        <div className="photo-container">
          <img
            className="detail-photo"
            src={product.photoUrl}
            alt={product.name}
          />
        </div>
        <aside className="detail-info">
          <span>
            <h3 className="text-title">{product.name}</h3>
            <p className="text-description">{product.description}</p>
            <h4 className="detail-price">{product.price}€</h4>
          </span>
          <button className="custom-button">Custom</button>
          <Link to="/">
            <button className="back-button">Back</button>
          </Link>
        </aside>
      </section>
    </main>
  );
}

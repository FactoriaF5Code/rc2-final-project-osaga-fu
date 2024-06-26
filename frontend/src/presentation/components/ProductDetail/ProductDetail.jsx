import "./ProductDetail.css";
import { Link, useParams } from "react-router-dom";
import { useContext, useEffect, useState } from "react";
import { ProductContext } from "../../../middleware/context/ProductContext";

import CustomModal from "../CustomModal/CustomModal";

export default function ProductDetail() {
  const { id } = useParams();

  const [product, setProduct] = useState(null);
  

  const { showProductById, handleCustomButtonClick, showModal } = useContext(ProductContext);

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
    <main className="detail-bg">
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
            <p className="detail-size">({product.size})</p>
            <h4 className="detail-price">{product.price}€</h4>
          </span>
          <button className="custom-button" onClick={handleCustomButtonClick}>
            Buy Now
          </button>
          <Link to="/">
            <button className="back-button">Back</button>
          </Link>
        </aside>
      </section>
      {showModal && <CustomModal />}
    </main>
  );
}

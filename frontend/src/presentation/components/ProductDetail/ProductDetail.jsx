import "./ProductDetail.css";
import { Link, useParams } from "react-router-dom";
import { useContext, useEffect, useState } from "react";
import { ProductContext } from "../../../middleware/context/ProductContext";
import Close from "../../assets/images/Close.png";

export default function ProductDetail() {
  const { id } = useParams();

  const [product, setProduct] = useState(null);
  const [showModal, setShowModal] = useState(false);

  const { showProductById } = useContext(ProductContext);

  useEffect(() => {
    const fetchProduct = async () => {
      const response = await showProductById(id);
      setProduct(response);
      console.log(id);
    };

    fetchProduct();
  }, [id]);

  function handleCustomButtonClick() {
    setShowModal(true);
  }

  function closeModal() {
    setShowModal(false);
  }

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
          <button className="custom-button" onClick={handleCustomButtonClick}>
            Custom
          </button>
          <Link to="/">
            <button className="back-button">Back</button>
          </Link>
        </aside>
      </section>
      {showModal && (
        <div className="modal-container">
          <div className="modal-content">
            <img
              className="close"
              onClick={closeModal}
              src={Close}
              alt="Close icon"
            />
            <h4 className="modal-title">Custom your own tags</h4>
            <form className="custom-form" action="" method="post">
              <div className="input-container">
                <label htmlFor="text">Text</label>
                <input type="text" name="" id="" />
              </div>
              <div className="input-container">
                <label htmlFor="color">Color</label>
                <input type="text" name="" id="" />
              </div>
              <div className="input-container">
                <label htmlFor="text">Typography</label>
                <select type="typography" name="" id="">
                  <option value="typo1">Typography 1</option>
                  <option value="typo2">Typography 2</option>
                  <option value="typo3">Typography 3</option>
                  <option value="typo4">Typography 4</option>
                </select>
              </div>
              <button className="modal-add-button">Add</button>
            </form>
          </div>
        </div>
      )}
    </main>
  );
}

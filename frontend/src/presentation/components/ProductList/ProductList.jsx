import "./ProductList.css";
import { Link } from "react-router-dom";
import  {ProductContext}  from "../../../middleware/context/ProductContext";
import { useContext, useEffect, useState } from "react";

export default function ProductList() {
  const { showProducts } = useContext(ProductContext);

  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const response = await showProducts();
      setData(response);
    };
    fetchData();
  }, []);


  return (
    <section className="list-container">
      <h3 className="list-title">Products</h3>
      <section className="products-wrapper">
        { data.map((product) => (
          <Link to={`/products/${product.id}`} key={product.id}>
            <article className="product-container">
              <div className="product-image-container">
                <img className="product-image" src={product.photoUrl} alt={product.name} />
              </div>
              <span className="product-info">
                <h5 className="info-title">{product.name}</h5>
                <h4 className="info-price">{product.price}€</h4>
              </span>
            </article>
          </Link>
        ))}
      </section>
    </section>
  );
}

import "./CartBar.css";
import Cart from "../../assets/images/Cart.png";
import {useContext} from "react";
import {ProductContext} from "../../../middleware/context/ProductContext.jsx";

export default function CartBar() {


    const {cartProducts} = useContext(ProductContext);

    return (
        <section className="cart-bar">
            <img className="cart-logo" src={Cart} alt="Cart logo"/>
            {cartProducts() > 0 && <span style={{color: "white"}}>{cartProducts()}</span>}
        </section>
    );
}

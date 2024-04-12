import "./CustomModal.css";
import Close from "../../assets/images/Close.png";
import { ProductContext } from "../../../middleware/context/ProductContext";
import { useContext } from "react";

export default function CustomModal() {
  const { closeModal, addToCart } = useContext(ProductContext);

  const handleSubmit = (e) => {
    e.preventDefault();
    closeModal();
    addToCart();
  };

  return (
    <div className="modal-container">
      <div className="modal-content">
        <img
          className="close"
          onClick={closeModal}
          src={Close}
          alt="Close icon"
        />
        <h4 className="modal-title">Custom your own tags!</h4>
        <form className="custom-form">
          <div className="input-container">
            <label htmlFor="text">Text</label>
            <input type="text" name="text" id="text" />
          </div>
          <div className="input-container">
            <label htmlFor="color">Color</label>
            <select name="typography" id="typography">
              <option value="red">Red</option>{" "}
              <option value="blue">Blue</option>
              <option value="green">Green</option>
              <option value="purple">Purple</option>
            </select>
          </div>
          <div className="input-container">
            <label htmlFor="typography">Typography</label>
            <select name="typography" id="typography">
              <option value="typo1">Arial</option>
              <option value="typo2">Courier New</option>
              <option value="typo3">Roboto</option>
              <option value="typo4">Machine Type</option>
            </select>
          </div>
          <button onClick={handleSubmit} className="modal-add-button">
            Add
          </button>
        </form>
      </div>
    </div>
  );
}

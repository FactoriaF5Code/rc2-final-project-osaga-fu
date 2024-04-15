import "./CustomModal.css";
import Close from "../../assets/images/Close.png";
import happy from "../../assets/images/happy-icon.png";
import { ProductContext } from "../../../middleware/context/ProductContext";
import { useContext, useState } from "react";
import { useParams } from "react-router-dom";

export default function CustomModal() {
  const { closeModal, addToCart } = useContext(ProductContext);

  const { id } = useParams();

  const [formData, setFormData] = useState({
    text: "",
    color: "Red",
    typography: "Arial",
    tagId: id,
    quantity: 1,
  });
  const [message, setMessage] = useState(null);
  const [formVisible, setFormVisible] = useState(true);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!formData.text || !formData.color || !formData.typography) {
      setMessage("Please fill out all fields");
      return;
    }

    try {
      await addToCart(formData);
      setMessage("Item added to cart successfully!");
      setFormVisible(false);
    } catch (error) {
      setMessage("Error adding item to cart. Please try again later.");
    }
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
        {message && (
          <span
            className={
              message.includes("successfully")
                ? "success-message"
                : "error-message"
            }
          >
            <h4 className="modal-title">{message} </h4>
            <img
              className="message-icon"
              src={message.includes("successfully") && happy}
              alt={message.includes("successfully") && "Happy icon"}
            />
          </span>
        )}
        {formVisible && (
          <form className="custom-form">
            <h4 className="modal-title">Custom your own tags!</h4>
            <div className="input-container">
              <label htmlFor="text">Text</label>
              <input
                type="text"
                name="text"
                id="text"
                value={formData.text}
                onChange={handleChange}
              />
            </div>
            <div className="input-container">
              <label htmlFor="color">Color</label>
              <select
                name="color"
                id="color"
                value={formData.color}
                onChange={handleChange}
              >
                <option value="Red">Red</option>
                <option value="Blue">Blue</option>
                <option value="Green">Green</option>
                <option value="Purple">Purple</option>
              </select>
            </div>
            <div className="input-container">
              <label htmlFor="typography">Typography</label>
              <select
                name="typography"
                id="typography"
                value={formData.typography}
                onChange={handleChange}
              >
                <option value="Arial">Arial</option>
                <option value="Courier New">Courier New</option>
                <option value="Roboto">Roboto</option>
                <option value="Machine Type">Machine Type</option>
              </select>
            </div>
            <button onClick={handleSubmit} className="modal-add-button">
              Add
            </button>
          </form>
        )}
      </div>
    </div>
  );
}

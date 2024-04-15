import "./ModifyModal.css";
import { useState } from "react";

export default function ModifyModal() {
  return (
    <div className="modal-container">
      <div className="modal-content">
        <h2 className="modal-title">Modify Cart Item</h2>
        <form className="custom-form">
          <label htmlFor="text">Text:</label>
          <input type="text" id="text" />
          <label htmlFor="color">Color:</label>
          <select name="color" id="color">
            <option value="Red">Red</option>
            <option value="Blue">Blue</option>
            <option value="Green">Green</option>
            <option value="Purple">Purple</option>
          </select>
          <label htmlFor="typography">Typography:</label>
          <select name="typography" id="typography">
            <option value="Arial">Arial</option>
            <option value="Courier New">Courier New</option>
            <option value="Roboto">Roboto</option>
            <option value="Machine Type">Machine Type</option>
          </select>
          <div className="button-container">
            <button className="modify-button">Save</button>
            <button className="delete-button">Cancel</button>
          </div>
        </form>
      </div>
    </div>
  );
}

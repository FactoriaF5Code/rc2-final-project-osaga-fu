import axios from "axios";

const END_POINT = "http://localhost:8080";

export class CartService {
  async getAllCarts() {
    return axios.get(`${END_POINT}/api/cart`).then((response) => response.data);
  }

  async addToCart(cartData) {
    return axios
      .post(`${END_POINT}/api/cart`, cartData)
      .then((response) => response.data);
  }

  async updateCart(cartId, cartData) {
    return axios
      .put(`${END_POINT}/api/cart/${cartId}`, cartData)
      .then((response) => response.data);
  }

  async deleteCart(cartId) {
    return axios
      .delete(`${END_POINT}/api/cart/${cartId}`)
      .then((response) => response.data);
  }
}

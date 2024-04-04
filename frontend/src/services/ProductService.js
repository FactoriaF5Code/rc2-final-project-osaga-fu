import axios from "axios";

const END_POINT = "http://localhost:8080";

export class ProductService {
  async showTags() {
    return axios
      .get(`${END_POINT}/api/products`)
      .then((response) => response.data);
  }

  async showTagById(id) {
    return axios
      .get(`${END_POINT}/api/products/${id}`)
      .then((response) => response.data);
  }
}

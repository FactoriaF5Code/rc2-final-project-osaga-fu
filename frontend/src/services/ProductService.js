import axios from "axios";

const END_POINT = "http://localhost:8080";

export class ProductService {
  async showTags() {
    return axios.get(`${END_POINT}/api/tags`).then((response) => response.data);
  }
}

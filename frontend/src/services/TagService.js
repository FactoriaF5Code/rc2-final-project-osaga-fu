import axios from "axios";

export class TagService {
  END_POINT = "http://localhost:8080";

  async showTags() {
    return axios.get(`${END_POINT}/api/products`);
  }
}

import "./Header.css";
import Logo from "../../assets/images/logo.png";
import { Link } from "react-router-dom";

export default function Header() {
  return (
    <header>
      <Link to="/">
        <img className="logo" src={Logo} alt="La Llama Laser Studio" />
      </Link>
      <span className="text-container">
        <h1 className="title-text">La Llama</h1>
        <h2 className="subtitle-text">Laser Studio</h2>
      </span>
    </header>
  );
}

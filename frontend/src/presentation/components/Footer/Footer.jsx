import "./Footer.css";
import Instagram from "../../assets/images/Instagram.png"
import Whatsapp from "../../assets/images/Whatsapp.png"
import Envelope from "../../assets/images/Envelope.png"

export default function Footer() {
  return (
    <footer>
      <span className="text-container">
        <h1 className="title-text">La Llama</h1>
        <h2 className="subtitle-text">Laser Studio</h2>
      </span>
      <hr />
      <section className="footer-bottom">
        <div className="footer-contact-container">
          <img className="logo-footer" src={Envelope} alt="Logo email" />
          <h5 className="footer-contact-text">lallamalaserstudio@gmail.com</h5>
        </div>
        <div className="footer-contact-container">
          <img className="logo-footer" src={Whatsapp} alt="Logo whatsapp" />
          <h5 className="footer-contact-text">+34 620 99 27 42</h5>
        </div>
        <div className="footer-contact-container">
          <img className="logo-footer" src={Instagram} alt="Logo Instagram" />
          <h5 className="footer-contact-text">lallama_laserstudio</h5>
        </div>
      </section>
    </footer>
  );
}

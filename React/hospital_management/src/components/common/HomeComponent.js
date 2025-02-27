import React from "react";
import "../../static/css/Home.css";

const HomeComponent = () => {
  return (
    <div>
      {/* Slider Section */}
      <div className="slider">
        <div className="slide">
          <h1>Welcome to Our Hospital</h1>
          <p>Providing the best healthcare services for you and your family.</p>
        </div>
      </div>

      {/* Services Section */}
      <section className="services">
        <h2>Our Services</h2>
        <div className="services-container">
          <div className="service-card">
            <h3>Emergency Care</h3>
            <p>24/7 emergency services with specialized doctors.</p>
          </div>
          <div className="service-card">
            <h3>Medical Consultation</h3>
            <p>Expert medical consultation for various health concerns.</p>
          </div>
          <div className="service-card">
            <h3>Diagnostic Services</h3>
            <p>State-of-the-art diagnostic and imaging facilities.</p>
          </div>
        </div>
      </section>

      {/* About Us Section */}
      <section className="about">
        <h2>About Our Hospital</h2>
        <p>
          Our hospital is committed to providing top-notch healthcare services
          with a team of highly qualified doctors and medical professionals.
        </p>
      </section>
    </div>
  );
};

export default HomeComponent;

import React from "react";
import { Link } from "react-router-dom";
import "../../static/css/NavBar.css"; // Import CSS for styling

const NavBar = () => {
  return (
    <nav className="navbar">
      <h2>Hospital Management</h2>
      <ul>
        <li>
          <Link to="/">Patient List</Link>
        </li>
        <li>
          <Link to="/add-patient">Add Patient</Link>
        </li>
      </ul>
    </nav>
  );
};

export default NavBar;
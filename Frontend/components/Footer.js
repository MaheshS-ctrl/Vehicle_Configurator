import React from "react";

const Footer = () => {
  return (
    <footer className="bg-white text-center border-t text-sm text-gray-500 z-50">
      <p>Contact Us | Home | About Us</p>
      <p>© {new Date().getFullYear()} V-CONF. All rights reserved.</p>
    </footer>
  );
};

export default Footer;

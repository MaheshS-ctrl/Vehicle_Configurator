"use client"; //can use react hooks //access to browser api

import { usePathname } from "next/navigation";
import React from "react";
import Link from "next/link";

const Navbar = () => {
  const pathname = usePathname();

  const navItems = [
    { name: "Home", path: "/" },
    { name: "Sign In", path: "/login" },
    { name: "Register", path: "/register" },
    { name: "Configure", path: "/config" },
    { name: "About", path: "/about" },
    { name: "Contact us", path: "/contact" },
  ];
  return (
    <nav className="shadow-md px-6 py-4 flex justify-between items-center z-50">
      <div className="text-xl font-bold text-white-600">V-CONF</div>
      <ul className="flex space-x-6">
        {navItems.map((item) => (
          <li key={item.name}>
            <Link
              href={item.path}
              className={`text-[#57564F] hover:text-[#E9E3DF] ${
                pathname === item.path ? "text-white-600 font-semibold" : ""
              }`}
            >
              {item.name}
            </Link>
          </li>
        ))}
      </ul>
    </nav>
  );
};

export default Navbar;

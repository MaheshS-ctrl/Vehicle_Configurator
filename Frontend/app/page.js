import Image from "next/image";

export default function Home() {
  return (
    <section className="home-container">
      <div className="overlay"></div>
      <h1 className="animate-slide-up">Welcome to V-CONF</h1>
      <p className="animate-slide-up">
        V-CONF is your all-in-one vehicle configurator solution designed for
        rental companies to select, customize, and purchase vehicles with ease.
        Start by signing in or registering your company to explore available
        models.
      </p>
      <div className="button-group animate-slide-up">
        <a href="/login" className="btn-primary">
          Sign in
        </a>
        <a href="/register" className="btn-secondary">
          Register
        </a>
      </div>
    </section>
  );
}

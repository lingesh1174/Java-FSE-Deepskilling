import React, { useState } from "react";

function Register() {
      const [form, setForm] = useState({
    fullName: "",
    email: "",
    password: "",
  });

  const [errors, setErrors] = useState({
    fullName: "",
    email: "",
    password: "",
  });

  const handleChange = (event) => {
    const { name, value } = event.target;
    let newErrors = { ...errors };

    switch (name) {
      case "fullName":
        newErrors.fullName =
          value.length < 5 ? "Full Name must be 5 characters long!" : "";
        break;
      case "email":
        const validEmailRegex =
          /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        newErrors.email = validEmailRegex.test(value)
          ? ""
          : "Email is not valid!";
        break;
      case "password":
        newErrors.password =
          value.length < 8 ? "Password must be 8 characters long!" : "";
        break;
      default:
        break;
    }

    setForm({ ...form, [name]: value });
    setErrors(newErrors);
  };

  const validateForm = () => {
    return (
      form.fullName.length >= 5 &&
      /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(form.email) &&
      form.password.length >= 8
    );
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    if (validateForm())
      alert("Valid Form");
    else {
      if (errors.fullName)
        alert(errors.fullName);
      if (errors.email)
        alert(errors.email);
      if (errors.password)
        alert(errors.password);
    }
  };

  return (
    <div className="register-container">
      <h1 className="heading">Register Here!!!</h1>
      <form onSubmit={handleSubmit} noValidate>
        <div className="form-group">
          <label>Name:</label>
          <input
            type="text"
            name="fullName"
            value={form.fullName}
            onChange={handleChange}
          />
        </div>
        <span className="error">{errors.fullName}</span>

        <div className="form-group">
          <label>Email:</label>
          <input
            type="email"
            name="email"
            value={form.email}
            onChange={handleChange}
          />
        </div>
        <span className="error">{errors.email}</span>

        <div className="form-group">
          <label>Password:</label>
          <input
            type="password"
            name="password"
            value={form.password}
            onChange={handleChange}
          />
        </div>
        <span className="error">{errors.password}</span>

        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;
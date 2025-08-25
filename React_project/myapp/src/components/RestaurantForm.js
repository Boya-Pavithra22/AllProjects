import React, { useState, useEffect } from "react";

function RestaurantForm() {
  const [formData, setFormData] = useState({
    restaurantName: "",
    ownerName: "",
    email: "",
    contact: "",
    address: "",
    cuisineType: "",
    openingHours: ""
  });

  const [submittedData, setSubmittedData] = useState(null);

  // Run on every render
  useEffect(() => {
    console.log("Restaurant Registration App Rendered");
  });

  // Run only once
  useEffect(() => {
    console.log("Welcome to Restaurant Registration Form!");
  }, []);

  // Run whenever form data changes
  useEffect(() => {
    console.log("Form updated:", formData);
  }, [formData]);

  // Auto-save every 5s
  useEffect(() => {
    const interval = setInterval(() => {
      console.log("Auto-saving data...", formData);
    }, 5000);

    return () => clearInterval(interval);
  }, [formData]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setSubmittedData(formData);
  };

  return (
  <div style={{ maxWidth: "900px", margin: "auto", fontFamily: "Arial" }}>
    <h1>🍴 Restaurant Registration Form</h1>
    <p>Welcome to Restaurant Registration 🏢</p>

    {/* form container with width 60% */}
    <div style={{ width: "60%", margin: "auto" }}>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="restaurantName"
          placeholder="Restaurant Name"
          value={formData.restaurantName}
          onChange={handleChange}
          required
        /><br /><br />

        <input
          type="text"
          name="ownerName"
          placeholder="Owner Name"
          value={formData.ownerName}
          onChange={handleChange}
          required
        /><br /><br />

        <input
          type="email"
          name="email"
          placeholder="Email"
          value={formData.email}
          onChange={handleChange}
          required
        /><br /><br />

        <input
          type="text"
          name="contact"
          placeholder="Contact Number"
          value={formData.contact}
          onChange={handleChange}
          required
        /><br /><br />

        <input
          type="text"
          name="address"
          placeholder="Address"
          value={formData.address}
          onChange={handleChange}
          required
        /><br /><br />

        <input
          type="text"
          name="cuisineType"
          placeholder="Cuisine Type"
          value={formData.cuisineType}
          onChange={handleChange}
          required
        /><br /><br />

        <input
          type="text"
          name="openingHours"
          placeholder="Opening Hours"
          value={formData.openingHours}
          onChange={handleChange}
          required
        /><br /><br />

        <button type="submit">Submit</button>
      </form>
    </div>

    {submittedData && (
      <div style={{ marginTop: "20px", width: "60%", margin: "auto" }}>
        <h3>📂 Submitted Data (JSON)</h3>
        <pre style={{ background: "#f4f4f4", padding: "10px", borderRadius: "5px" }}>
          {JSON.stringify(submittedData, null, 2)}
        </pre>
      </div>
    )}
  </div>
);

}

export default RestaurantForm;

import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css"; // ✅ import bootstrap styling

const BakingForm = () => {
  // state for form fields
  const [form, setForm] = useState({
    itemName: "",
    quantity: "",
    ingredients: "",
    time: "",
    category: ""
  });

  // state for submitted items list
  const [items, setItems] = useState([]);

  // update form fields on change
  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  // handle form submit
  const handleSubmit = (e) => {
    e.preventDefault();

    // add new item to list
    setItems([...items, form]);

    // reset form fields
    setForm({ itemName: "", quantity: "", ingredients: "", time: "", category: "" });
  };

  return (
    <div className="container mt-4" style={{ maxWidth: "600px" }}>
      {/* Form Card */}
      <div className="card p-4 shadow-sm">
        <h3 className="text-center mb-3">Baking Items Form</h3>
        <form onSubmit={handleSubmit}>
          <input
            name="itemName"
            value={form.itemName}
            onChange={handleChange}
            placeholder="Item Name"
            className="form-control mb-2"
            required
          />
          <input
            type="number"
            name="quantity"
            value={form.quantity}
            onChange={handleChange}
            placeholder="Quantity"
            className="form-control mb-2"
            required
          />
          <textarea
            name="ingredients"
            value={form.ingredients}
            onChange={handleChange}
            placeholder="Ingredients"
            className="form-control mb-2"
          />
          <input
            type="text"
            name="time"
            value={form.time}
            onChange={handleChange}
            placeholder="Baking Time (mins)"
            className="form-control mb-2"
          />

          {/* Select Dropdown */}
          <select
            name="category"
            value={form.category}
            onChange={handleChange}
            className="form-control mb-3"
            required
          >
            <option value="">--Select Category--</option>
            <option value="Cake">Cake</option>
            <option value="Bread">Bread</option>
            <option value="Pastry">Pastry</option>
          </select>

          <button className="btn btn-primary w-100">Add Item</button>
        </form>
      </div>

      {/* Display Table */}
      {items.length > 0 && (
        <div className="card mt-4 shadow-sm p-3">
          <h4 className="mb-3">Submitted Baking Items</h4>
          <table className="table table-bordered table-striped">
            <thead className="table-dark">
              <tr>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Ingredients</th>
                <th>Baking Time</th>
                <th>Category</th>
              </tr>
            </thead>
            <tbody>
              {items.map((it, i) => (
                <tr key={i}>
                  <td>{it.itemName}</td>
                  <td>{it.quantity}</td>
                  <td>{it.ingredients}</td>
                  <td>{it.time}</td>
                  <td>{it.category}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default BakingForm;

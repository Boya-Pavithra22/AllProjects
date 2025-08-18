import React, { useState } from "react";

const BakingForm = () => {
  // state for form fields
  const [form, setForm] = useState({ itemName: "", quantity: "", ingredients: "", time: "", category: "" });
  // state for list of submitted items
  const [items, setItems] = useState([]);

  // update form fields on change
  const handleChange = e => setForm({ ...form, [e.target.name]: e.target.value });

  // handle form submit
  const handleSubmit = e => {
    e.preventDefault();
    setItems([...items, form]);       // add new item to list
    setForm({ itemName: "", quantity: "", ingredients: "", time: "", category: "" }); // reset form
  };

  return (
    <div className="container mt-4">
      {/* Form Card */}
      <div className="card p-3 shadow">
        <h3>Baking Items Form</h3>
        <form onSubmit={handleSubmit}>
          {/* Input fields */}
          <input name="itemName" value={form.itemName} onChange={handleChange} placeholder="Item Name" className="form-control mb-2" required />
          <input type="number" name="quantity" value={form.quantity} onChange={handleChange} placeholder="Quantity" className="form-control mb-2" required />
          <textarea name="ingredients" value={form.ingredients} onChange={handleChange} placeholder="Ingredients" className="form-control mb-2" />
          <input type="text" name="time" value={form.time} onChange={handleChange} placeholder="Baking Time (mins)" className="form-control mb-2" />
          
          {/* Select Dropdown */}
          <select name="category" value={form.category} onChange={handleChange} className="form-control mb-2" required>
            <option value="">--Select Category--</option>
            <option value="Cake">Cake</option>
            <option value="Bread">Bread</option>
            <option value="Pastry">Pastry</option>
          </select>

          <button className="btn btn-primary">Add Item</button>
        </form>
      </div>

      {/* Display Table */}
      {items.length > 0 && (
        <table className="table table-bordered table-striped mt-3">
          <thead>
            <tr>
              <th>Item Name</th><th>Quantity</th><th>Ingredients</th><th>Baking Time</th><th>Category</th>
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
      )}
    </div>
  );
};

export default BakingForm;

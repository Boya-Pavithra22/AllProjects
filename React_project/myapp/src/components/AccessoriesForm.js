import React, { Component } from "react";

class AccessoriesForm extends Component {
  constructor(props) {
    super(props);
    // Initialize state for all form fields + submission flag
    this.state = {
      accessoryName: "", // text input
      description: "",   // textarea
      category: "",      // dropdown
      brand: "",         // radio
      available: false,  // checkbox
      warranty: "",      // number input
      submitted: false   // to show table after submit
    };
  }

  // Handle changes for all inputs (text, select, radio, checkbox, number)
  handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    this.setState({
      [name]: type === "checkbox" ? checked : value // handle checkbox separately
    });
  };

  // On form submit: prevent refresh + mark as submitted
  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({ submitted: true });
  };

  render() {
    return (
      <div className="container mt-4">
        {/* Form Card */}
        <div className="card shadow">
          <div className="card-header bg-primary text-white">
            <h3>Accessories Form</h3>
          </div>
          <div className="card-body">
            {/* Form starts here */}
            <form onSubmit={this.handleSubmit}>

              {/* Accessory Name (Text Input) */}
              <div className="form-group">
                <label>Accessory Name</label>
                <input
                  type="text"
                  name="accessoryName"
                  className="form-control"
                  value={this.state.accessoryName} // controlled by state
                  onChange={this.handleChange}
                  required
                />
              </div>

              {/* Description (Textarea) */}
              <div className="form-group">
                <label>Description</label>
                <textarea
                  name="description"
                  className="form-control"
                  rows="3"
                  value={this.state.description}
                  onChange={this.handleChange}
                ></textarea>
              </div>

              {/* Category (Dropdown) */}
              <div className="form-group">
                <label>Category</label>
                <select
                  name="category"
                  className="form-control"
                  value={this.state.category}
                  onChange={this.handleChange}
                >
                  <option value="">--Select--</option>
                  <option value="Mobile">Mobile</option>
                  <option value="Laptop">Laptop</option>
                  <option value="Audio">Audio</option>
                  <option value="Other">Other</option>
                </select>
              </div>

              {/* Brand (Radio Buttons) */}
              <div className="form-group">
                <label className="d-block">Brand</label>
                {/* Apple */}
                <div className="form-check form-check-inline">
                  <input
                    type="radio"
                    name="brand"
                    value="Apple"
                    className="form-check-input"
                    checked={this.state.brand === "Apple"} // check if selected
                    onChange={this.handleChange}
                  />
                  <label className="form-check-label">Apple</label>
                </div>
                {/* Samsung */}
                <div className="form-check form-check-inline">
                  <input
                    type="radio"
                    name="brand"
                    value="Samsung"
                    className="form-check-input"
                    checked={this.state.brand === "Samsung"}
                    onChange={this.handleChange}
                  />
                  <label className="form-check-label">Samsung</label>
                </div>
                {/* Sony */}
                <div className="form-check form-check-inline">
                  <input
                    type="radio"
                    name="brand"
                    value="Sony"
                    className="form-check-input"
                    checked={this.state.brand === "Sony"}
                    onChange={this.handleChange}
                  />
                  <label className="form-check-label">Sony</label>
                </div>
              </div>

              {/* Available (Checkbox) */}
              <div className="form-group form-check">
                <input
                  type="checkbox"
                  name="available"
                  className="form-check-input"
                  checked={this.state.available} // true/false from state
                  onChange={this.handleChange}
                />
                <label className="form-check-label">Available in Stock</label>
              </div>

              {/* Warranty (Number Input) */}
              <div className="form-group">
                <label>Warranty (Years)</label>
                <input
                  type="number"
                  name="warranty"
                  className="form-control"
                  value={this.state.warranty}
                  onChange={this.handleChange}
                />
              </div>

              {/* Submit Button */}
              <button type="submit" className="btn btn-success mt-2">
                Submit
              </button>
            </form>
          </div>
        </div>

        {/* Display Submitted Data in Table */}
        {this.state.submitted && (
          <div className="card mt-4">
            <div className="card-header bg-info text-white">
              <h4>Submitted Accessory Details</h4>
            </div>
            <div className="card-body">
              <table className="table table-bordered">
                <thead className="thead-dark">
                  <tr>
                    <th>Field</th>
                    <th>Value</th>
                  </tr>
                </thead>
                <tbody>
                  {/* Accessory Name */}
                  <tr>
                    <td><strong>Accessory Name</strong></td>
                    <td>{this.state.accessoryName}</td>
                  </tr>
                  {/* Description */}
                  <tr>
                    <td><strong>Description</strong></td>
                    <td>{this.state.description}</td>
                  </tr>
                  {/* Category */}
                  <tr>
                    <td><strong>Category</strong></td>
                    <td>{this.state.category}</td>
                  </tr>
                  {/* Brand */}
                  <tr>
                    <td><strong>Brand</strong></td>
                    <td>{this.state.brand}</td>
                  </tr>
                  {/* Available */}
                  <tr>
                    <td><strong>Available</strong></td>
                    <td>{this.state.available ? "Yes" : "No"}</td>
                  </tr>
                  {/* Warranty */}
                  <tr>
                    <td><strong>Warranty</strong></td>
                    <td>{this.state.warranty} years</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        )}
      </div>
    );
  }
}

export default AccessoriesForm;

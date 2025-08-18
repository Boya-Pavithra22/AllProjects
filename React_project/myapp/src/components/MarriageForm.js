import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

class MarriageForm extends Component {
  state = {
    brideName: "",
    groomName: "",
    date: "",
    venue: "",
    submitted: null
  };

  // Update state when input changes
  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  // Submit form
  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({
      submitted: {
        brideName: this.state.brideName,
        groomName: this.state.groomName,
        date: this.state.date,
        venue: this.state.venue
      },
      // reset form fields
      brideName: "",
      groomName: "",
      date: "",
      venue: ""
    });
  };

  render() {
    return (
      <div className="container mt-4" style={{ maxWidth: "500px" }}>
        {/* Form Card */}
        <div className="card shadow-sm p-4">
          <h3 className="text-center mb-4">Marriage Form</h3>

          <form onSubmit={this.handleSubmit}>
            <div className="form-group mb-3">
              <label>Bride Name</label>
              <input
                type="text"
                className="form-control"
                name="brideName"
                value={this.state.brideName}
                onChange={this.handleChange}
                placeholder="Enter bride name"
                required
              />
            </div>

            <div className="form-group mb-3">
              <label>Groom Name</label>
              <input
                type="text"
                className="form-control"
                name="groomName"
                value={this.state.groomName}
                onChange={this.handleChange}
                placeholder="Enter groom name"
                required
              />
            </div>

            <div className="form-group mb-3">
              <label>Marriage Date</label>
              <input
                type="date"
                className="form-control"
                name="date"
                value={this.state.date}
                onChange={this.handleChange}
                required
              />
            </div>

            <div className="form-group mb-3">
              <label>Venue</label>
              <input
                type="text"
                className="form-control"
                name="venue"
                value={this.state.venue}
                onChange={this.handleChange}
                placeholder="Enter venue"
                required
              />
            </div>

            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Submitted Details Card */}
        {this.state.submitted && (
          <div className="card mt-4 shadow-sm p-4">
            <h4 className="mb-3">Marriage Details</h4>
            <table className="table">
              <tbody>
                <tr>
                  <td><strong>Bride Name:</strong></td>
                  <td>{this.state.submitted.brideName}</td>
                </tr>
                <tr>
                  <td><strong>Groom Name:</strong></td>
                  <td>{this.state.submitted.groomName}</td>
                </tr>
                <tr>
                  <td><strong>Date:</strong></td>
                  <td>{this.state.submitted.date}</td>
                </tr>
                <tr>
                  <td><strong>Venue:</strong></td>
                  <td>{this.state.submitted.venue}</td>
                </tr>
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

export default MarriageForm;

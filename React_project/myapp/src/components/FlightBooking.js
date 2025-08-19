import React, { Component, createRef } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

// ✅ Controlled Component
class FlightBookingControlled extends Component {
  state = {
    name: "",
    email: "",
    gender: "",
    meal: "",
    request: "",
    submitted: null,
  };

  handleChange = (e) => this.setState({ [e.target.name]: e.target.value });

  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({
      submitted: {
        name: this.state.name,
        email: this.state.email,
        gender: this.state.gender,
        meal: this.state.meal,
        request: this.state.request,
      },
      name: "",
      email: "",
      gender: "",
      meal: "",
      request: "",
    });
  };

  render() {
    return (
      <div className="card p-3 shadow">
        <h4 className="mb-3">Controlled Flight Booking Form</h4>
        <form onSubmit={this.handleSubmit}>
          <input
            className="form-control mb-2"
            name="name"
            value={this.state.name}
            onChange={this.handleChange}
            placeholder="Passenger Name"
            required
          />
          <input
            type="email"
            className="form-control mb-2"
            name="email"
            value={this.state.email}
            onChange={this.handleChange}
            placeholder="Email"
            required
          />

          {/* Gender */}
          <div className="mb-2">
            <label className="fw-bold">Gender:</label>
            <div>
              <input
                type="radio"
                name="gender"
                value="Male"
                checked={this.state.gender === "Male"}
                onChange={this.handleChange}
                className="form-check-input me-2"
              />
              Male
              <input
                type="radio"
                name="gender"
                value="Female"
                checked={this.state.gender === "Female"}
                onChange={this.handleChange}
                className="form-check-input ms-3 me-2"
              />
              Female
            </div>
          </div>

          {/* Meal */}
          <select
            className="form-control mb-2"
            name="meal"
            value={this.state.meal}
            onChange={this.handleChange}
            required
          >
            <option value="">--Select Meal Preference--</option>
            <option value="Veg">Veg</option>
            <option value="Non-Veg">Non-Veg</option>
          </select>

          {/* Special Request */}
          <textarea
            className="form-control mb-2"
            name="request"
            value={this.state.request}
            onChange={this.handleChange}
            placeholder="Special Request"
          />

          <button className="btn btn-primary w-100">Submit</button>
        </form>

        {/* Display Submitted Data */}
        {this.state.submitted && (
          <table className="table table-bordered mt-3">
            <tbody>
              <tr><td><strong>Name</strong></td><td>{this.state.submitted.name}</td></tr>
              <tr><td><strong>Email</strong></td><td>{this.state.submitted.email}</td></tr>
              <tr><td><strong>Gender</strong></td><td>{this.state.submitted.gender}</td></tr>
              <tr><td><strong>Meal</strong></td><td>{this.state.submitted.meal}</td></tr>
              <tr><td><strong>Request</strong></td><td>{this.state.submitted.request}</td></tr>
            </tbody>
          </table>
        )}
      </div>
    );
  }
}

// ✅ Uncontrolled Component
class FlightBookingUncontrolled extends Component {
  flightNoRef = createRef();
  sourceRef = createRef();
  destinationRef = createRef();
  dateRef = createRef();
  termsRef = createRef();
  state = { submitted: null };

  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({
      submitted: {
        flightNo: this.flightNoRef.current.value,
        source: this.sourceRef.current.value,
        destination: this.destinationRef.current.value,
        date: this.dateRef.current.value,
        terms: this.termsRef.current.checked ? "Accepted" : "Not Accepted",
      },
    });

    e.target.reset(); // reset form
  };

  render() {
    return (
      <div className="card p-3 shadow mt-4">
        <h4 className="mb-3">Uncontrolled Flight Booking Form</h4>
        <form onSubmit={this.handleSubmit}>
          <input ref={this.flightNoRef} className="form-control mb-2" placeholder="Flight Number" required />
          <input ref={this.sourceRef} className="form-control mb-2" placeholder="Source" required />
          <input ref={this.destinationRef} className="form-control mb-2" placeholder="Destination" required />
          <input type="date" ref={this.dateRef} className="form-control mb-2" required />

          <div className="form-check mb-2">
            <input type="checkbox" ref={this.termsRef} className="form-check-input" id="terms" />
            <label htmlFor="terms" className="form-check-label">Accept Terms & Conditions</label>
          </div>

          <button className="btn btn-success w-100">Submit</button>
        </form>

        {/* Display Submitted Data */}
        {this.state.submitted && (
          <div className="card mt-3 p-3 shadow-sm">
            <h5>Booking Details</h5>
            <p><strong>Flight No:</strong> {this.state.submitted.flightNo}</p>
            <p><strong>Source:</strong> {this.state.submitted.source}</p>
            <p><strong>Destination:</strong> {this.state.submitted.destination}</p>
            <p><strong>Date:</strong> {this.state.submitted.date}</p>
            <p><strong>Terms:</strong> {this.state.submitted.terms}</p>
          </div>
        )}
      </div>
    );
  }
}

// ✅ Parent Component
class App extends Component {
  render() {
    return (
      <div className="container mt-4">
        <h2 className="text-center mb-4">Flight Booking Application</h2>
        <div className="row">
          <div className="col-md-6">
            <FlightBookingControlled />
          </div>
          <div className="col-md-6">
            <FlightBookingUncontrolled />
          </div>
        </div>
      </div>
    );
  }
}

export default App;

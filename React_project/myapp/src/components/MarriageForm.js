// Import React and the base Component class
import React, { Component } from "react";
// Import Bootstrap styles for quick styling
import "bootstrap/dist/css/bootstrap.min.css";

// Define a Class Component named MarriageForm
class MarriageForm extends Component {
  // Initialize component state with form fields + submitted data holder
  state = {
    brideName: "",   // text input for bride name
    groomName: "",   // text input for groom name
    date: "",        // date input for marriage date
    venue: "",       // text input for venue
    submitted: null  // will hold a snapshot of submitted values
  };

  // Generic change handler for all inputs
  handleChange = (e) => {
    // e.target.name matches the state key; e.target.value is the new value
    this.setState({ [e.target.name]: e.target.value });
  };

  // Handle form submission
  handleSubmit = (e) => {
    e.preventDefault(); // stop page refresh
    // Save current field values into 'submitted' and clear the form
    this.setState({
      submitted: {
        brideName: this.state.brideName,
        groomName: this.state.groomName,
        date: this.state.date,
        venue: this.state.venue
      },
      // reset inputs
      brideName: "",
      groomName: "",
      date: "",
      venue: ""
    });
  };

  // Render UI
  render() {
    return (
      // Bootstrap container with a max width for nicer layout
      <div className="container mt-4" style={{ maxWidth: "500px" }}>
        {/* Card wrapping the form */}
        <div className="card shadow-sm p-4">
          {/* Title */}
          <h3 className="text-center mb-4">Marriage Form</h3>

          {/* Form with submit handler */}
          <form onSubmit={this.handleSubmit}>
            {/* Bride Name field */}
            <div className="form-group mb-3">
              <label>Bride Name</label>
              <input
                type="text"
                className="form-control"
                name="brideName"                 // ties to state key
                value={this.state.brideName}     // controlled value
                onChange={this.handleChange}     // updates state on type
                placeholder="Enter bride name"
                required                         // basic HTML validation
              />
            </div>

            {/* Groom Name field */}
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

            {/* Marriage Date field */}
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

            {/* Venue field */}
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

            {/* Submit button triggers handleSubmit */}
            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Conditionally render submitted details card if we have data */}
        {this.state.submitted && (
          <div className="card mt-4 shadow-sm p-4">
            {/* Section title */}
            <h4 className="mb-3">Marriage Details</h4>
            {/* Simple table showing submitted values */}
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

// Export component so it can be imported and used elsewhere
export default MarriageForm;

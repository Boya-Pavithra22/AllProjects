import React, { Component } from "react";

/* Functional Component: TelevisionList
   - Receives 'models' as props
   - Displays each model in a <li> */
function TelevisionList({ models }) {
  return (
    <ul>
      {models.map((model, index) => (
        <li key={index}>{model}</li>
      ))}
    </ul>
  );
}

/* Class Component: TelevisionManager
   - Manages list of television models in state
   - Provides input + button to add a new model
   - Passes models to TelevisionList as props */
class TelevisionManager extends Component {
  // Initial state with some models
  state = {
    models: ["Samsung QLED", "LG OLED", "Sony Bravia"],
    newModel: "" // for input field
  };

  // Update newModel as user types
  handleChange = (e) => {
    this.setState({ newModel: e.target.value });
  };

  // Add new television model using spread operator
  addModel = () => {
    const model = this.state.newModel.trim();
    if (!model) return; // ignore empty input

    // Update state: keep old models + add new one
    this.setState((prevState) => ({
      models: [...prevState.models, model], // spread operator
      newModel: "" // clear input field
    }));
  };

  // Render method
  render() {
    return (
      <div style={{ padding: "20px", fontFamily: "sans-serif" }}>
        <h2>Television Manager</h2>

        {/* Input controlled by state */}
        <input
          type="text"
          value={this.state.newModel}
          onChange={this.handleChange}
          placeholder="Enter new TV model"
        />

        {/* Button adds new model */}
        <button onClick={this.addModel} style={{ marginLeft: "8px" }}>
          Add Model
        </button>

        {/* Pass models to child component */}
        <h3>Available Models:</h3>
        <TelevisionList models={this.state.models} />
      </div>
    );
  }
}

/* Root Component: App
   - Renders TelevisionManager */
function App() {
  return (
    <div>
      <TelevisionManager />
    </div>
  );
}

export default App;

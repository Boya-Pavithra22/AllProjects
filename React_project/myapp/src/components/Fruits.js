import React, { Component } from "react";// Importing React and Component class from react library

/* Functional Component: FruitList
   - Receives 'fruits' as a prop
   - Loops over fruits using map()
   - Displays each fruit inside a <li> */
function FruitList({ fruits }) {
  return (
    <ul>
      {fruits.map((fruit, index) => (
        <li key={index}>{fruit}</li>// 'key' helps in identifying each list items.
      ))}
    </ul>
  );
}

/* Class Component: Fruits
   - Manages fruits state and newFruit input
   - Provides UI to add a fruit
   - Passes fruits list to FruitList as props */
class Fruits extends Component {
  // State contains the fruits array and newFruit input value
  state = {
    fruits: ["Apple", "Banana", "Orange"], // initial list
    newFruit: "" // input starts empty
  };

  // Updates newFruit in state whenever user types in input
  handleChange = (e) => {
    this.setState({ newFruit: e.target.value });
  };

  // Adds a new fruit to the list when user clicks "Add"
  addFruit = () => {
    const fruit = this.state.newFruit.trim(); // remove spaces
    if (!fruit) return; // do nothing if input is empty

    // Update state:
    // 1. Spread old fruits into a new array
    // 2. Append the new fruit
    // 3. Reset newFruit input to empty string
    this.setState((prev) => ({
      fruits: [...prev.fruits, fruit],
      newFruit: ""
    }));
  };

  // Render method: describes what to display on screen
  render() {
    return (
      <div>
        <h2>Fruit Manager</h2>

        {/* Controlled input:
            - value comes from state.newFruit
            - onChange updates state as user types */}
        <input
          type="text"
          value={this.state.newFruit}
          onChange={this.handleChange}
          placeholder="Enter fruit"
        />

        {/* Button that calls addFruit() when clicked */}
        <button onClick={this.addFruit}>Add</button>

        {/* Pass fruits state down to FruitList as props */}
        <FruitList fruits={this.state.fruits} />
      </div>
    );
  }
}

/* Root Functional Component: App
   - Renders the Fruits class component */
function App() {
  return (
    <div style={{ padding: "20px" }}>
      {/* Fruits component is displayed inside App */}
      <Fruits />
    </div>
  );
}

// Export App as the default so React can render it in index.js
export default App;

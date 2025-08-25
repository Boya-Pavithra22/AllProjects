import React, { useState } from "react";

function App() {
  // Parent state: fruits and selectedFruit
  const [fruits, setFruits] = useState(["Apple", "Mango"]);
  const [selectedFruit, setSelectedFruit] = useState("");

  // Child B adds Orange to fruits (Child → Parent)
  const addFruit = () => {
    setFruits([...fruits, "Orange"]);
  };

  return (
    <div style={{ fontFamily: "Arial", padding: "20px" }}>
      <h1>🍎 React Parent / Child / Sibling Communication</h1>

      {/* Child A: Display fruit list */}
      <ChildA fruits={fruits} onSelectFruit={setSelectedFruit} />

      {/* Child B: Add new fruit */}
      <ChildB onAddFruit={addFruit} />

      {/* Child C: Show selected fruit */}
      <ChildC selectedFruit={selectedFruit} />
    </div>
  );
}

// Child A: Gets fruits from parent and lets user select one
function ChildA({ fruits, onSelectFruit }) {
  return (
    <div style={{ marginBottom: "20px" }}>
      <h2>Child A – Fruit List</h2>
      <ul>
        {fruits.map((fruit, index) => (
          <li
            key={index}
            onClick={() => onSelectFruit(fruit)} // Pass selected fruit back to parent
            style={{ cursor: "pointer" }}
          >
            {fruit}
          </li>
        ))}
      </ul>
      <small>(Click a fruit to select it 👆)</small>
    </div>
  );
}

// Child B: Sends a new fruit ("Orange") to parent
function ChildB({ onAddFruit }) {
  return (
    <div style={{ marginBottom: "20px" }}>
      <h2>Child B – Add Fruit</h2>
      <button onClick={onAddFruit}>Send Fruit (Orange)</button>
    </div>
  );
}

// Child C: Displays the fruit selected in Child A
function ChildC({ selectedFruit }) {
  return (
    <div>
      <h2>Child C – Selected Fruit</h2>
      {selectedFruit ? (
        <p>Selected Fruit: <b>{selectedFruit}</b></p>
      ) : (
        <p>No fruit selected yet 🍏</p>
      )}
    </div>
  );
}

export default App;

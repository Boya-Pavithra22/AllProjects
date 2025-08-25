import React, { useState } from "react";
import GroceryList from './components/GroseryList';
import Car from './components/Car';
import Phone from './components/Phone';
import SweetsList from './components/SweetsList';
import Electronics from './components/Electronics';
import CanteenMenu from './components/CanteenMenu';
import JuiceList from './components/JuiceList';
import Restaurant from './components/Restaurant';
import TempleList from './components/TempleList';
import TailorShop from './components/TailorShop';
import Fruits from './components/Fruits';
import Television from './components/Television';
import MarriageForm from './components/MarriageForm';
import AccessoriesForm from './components/AccessoriesForm';
import BakingForm from './components/BakingForm';
import MovieForm from './components/MovieForm';
import FlightBooking from './components/FlightBooking';
import RestaurantForm from './components/RestaurantForm';
import Communication from './components/Communication'; 
import Chair from "./components/Chair";
import Table from "./components/Table";
import Sofa from "./components/Sofa";
import Bed from "./components/Bed";
import './App.css';  // instead of './styles/App.css'
import FestivalApp from "./components/FestivalApp";




const groceries = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];

function App() {
  const [selectedFurniture, setSelectedFurniture] = useState("Chair");

  // Switch–case for furniture only
  const renderFurniture = () => {
    switch (selectedFurniture) {
      case "Chair":
        return <Chair />;
      case "Table":
        return <Table />;
      case "Sofa":
        return <Sofa />;
      case "Bed":
        return <Bed />;
      default:
        return <h3>Please select furniture</h3>;
    }
  };

  return (
    <div className="App">
      <h1>Furniture Store</h1>

      {/* Dropdown to select furniture */}
      <select
        value={selectedFurniture}
        onChange={(e) => setSelectedFurniture(e.target.value)}
      >
        <option value="Chair">Chair</option>
        <option value="Table">Table</option>
        <option value="Sofa">Sofa</option>
        <option value="Bed">Bed</option>
      </select>

      {/* Show furniture dynamically */}
      <div>{renderFurniture()}</div>

      {/* Your other components */}
      <GroceryList items={groceries} />
      <Car brand="Hundai" model="i20" color="Black" year="2024" />
      <Phone />
      <SweetsList />
      <Electronics />
      <CanteenMenu />
      <JuiceList />
      <Restaurant />
      <TempleList />
      <TailorShop />
      <Fruits />
      <Television />
      <MarriageForm />
      <AccessoriesForm />
      <BakingForm />
      <MovieForm />
      <FlightBooking />
      <RestaurantForm />
      <Communication />
      <FestivalApp />
      </div>
  );
}

export default App;

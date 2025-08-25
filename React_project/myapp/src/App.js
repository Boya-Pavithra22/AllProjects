import React, { useState } from "react";
import GroceryList from './components/GroceryList';  // ✅ fixed spelling
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
import FestivalApp from "./components/FestivalApp";
import MainComponent from "./components/MainComponent";
import './App.css';

const groceries = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];

function App() {
  const [selectedFurniture, setSelectedFurniture] = useState("Chair");

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
      <GroceryList items={groceries} />
      <hr />

      <Car brand="Hundai" model="i20" color="Black" year="2024" />
      <hr />

      <Phone />
      <hr />

      <SweetsList />
      <hr />

      <Electronics />
      <hr />

      <CanteenMenu />
      <hr />

      <JuiceList />
      <hr />

      <Restaurant />
      <hr />

      <RestaurantForm />
      <hr />

      <TempleList />
      <hr />

      <TailorShop />
      <hr />

      <Fruits />
      <hr />

      <Television />
      <hr />

      <MarriageForm />
      <hr />

      <AccessoriesForm />
      <hr />

      <BakingForm />
      <hr />

      <MovieForm />
      <hr />

      <FlightBooking />
      <hr />

      <h1>Furniture Store</h1>
      <select
        value={selectedFurniture}
        onChange={(e) => setSelectedFurniture(e.target.value)}
      >
        <option value="Chair">Chair</option>
        <option value="Table">Table</option>
        <option value="Sofa">Sofa</option>
        <option value="Bed">Bed</option>
      </select>
      <div>{renderFurniture()}</div>
      <hr />

      <Communication />
      <hr />

      <FestivalApp />
      <hr />

      <MainComponent />
  
    </div>
  );
}

export default App;

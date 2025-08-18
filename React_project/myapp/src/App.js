import React from 'react';
import GroceryList from '../src/components/GroseryList';
import Car from '../src/components/Car';
import Phone from '../src/components/Phone';
import SweetsList from '../src/components/SweetsList';
import Electronics from '../src/components/Electronics';
import CanteenMenu from '../src/components/CanteenMenu';
import JuiceList from '../src/components/JuiceList';
import Restaurant from '../src/components/Restaurant';
import TempleList from '../src/components/TempleList';
import TailorShop from '../src/components/TailorShop';
import './App.css';  // instead of './styles/App.css'




const groceries = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];

function App() {
  return (
    <div className="App">
      <GroceryList items={groceries} />
      <Car brand="Toyota" model="Fortuner" color="Black" year="2022" />
      <Phone />
      <SweetsList />
      <Electronics />
      <CanteenMenu />
      <JuiceList />
      <Restaurant />
      <TempleList />
      <TailorShop />
    </div>
  );
}

export default App;

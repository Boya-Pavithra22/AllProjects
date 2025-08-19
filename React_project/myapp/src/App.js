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
import Fruits from '../src/components/Fruits';
import Television from '../src/components/Television';
import MarriageForm from '../src/components/MarriageForm';
import AccessoriesForm from '../src/components/AccessoriesForm';
import BakingForm from '../src/components/BakingForm';
import MovieForm from '../src/components/MovieForm';
import FlightBooking from '../src/components/FlightBooking';
import './App.css';  // instead of './styles/App.css'




const groceries = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];

function App() {
  return (
    <div className="App">
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
    </div>
  );
}

export default App;

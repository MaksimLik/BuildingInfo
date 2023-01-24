import './App.css';
import Header from './components/Header';
import BuildingsList from './components/BuildingsList';
import { Routes, Route, Router } from 'react-router-dom';
import BuildingDetails from './components/BuildingDetails';
import NewBuildingForm from './components/NewBuildingForm';
import React, {useState} from 'react';


function App() {
 
  const [building, setBuilding] = useState({})

  
  function handleBuildingsDetailsClick(building) {
    setBuilding(building)
  }

  return (
  
    <div className="App">
     
        <Header/>
       
          <div className='main-content'>
              <Routes>
                  <Route path="" element={<BuildingsList onClick={(building) => handleBuildingsDetailsClick(building)}/>}/>
                  <Route path="new-buildings" element={<NewBuildingForm/>}/>
                  <Route path="building-details/*" element={<BuildingDetails data={building}/>}/>    
              </Routes> 
          </div>
     
    </div>

  );
}

export default App;



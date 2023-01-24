import React, {useEffect, useState} from 'react'
import Building  from './Building';
import BuildingDetails from './BuildingDetails';
import "../styles/BuildingsList.css"

 function BuildingsList(props) {

    const [data, setData] = useState([]);
    
  
    useEffect(() => {
      fetch('http://localhost:8080/api/v1/buildings')
        .then(response => response.json())
        .then(res => setData(res));
    }, []);
  
  

  
    const listItems = data.map(item => (
      <Building 
        key={item.id}
        data={item}
        onClick={() => props.onClick(item)} // przekazywanie itemu
      />
    ))



    return (
        <main className='main'>
            <h1 className='main_heading'>Wszystkie budynki</h1>
            <div className='buildings_list'>
                {listItems}
            </div>
        </main>
    )
}
export default BuildingsList;
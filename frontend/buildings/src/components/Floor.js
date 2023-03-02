import React from "react";
import Room from "./Room"
import {Link} from 'react-router-dom'
import "../styles/Floor.css"

function Floor(props) {
    const floor = props.data

    const roomsList = floor.rooms.map(room => (
        <>
            <Room key={room.id}
                  data={room}
                  floorId={floor.id}
                  onClick={() => props.handleDeleteRoomButton(room.id)}
                  threshold={props.threshold}/>
        </>
    ))
    return (
        <div className="floor_container">
            <h2 className="floor_heading">{floor.name}</h2>
            <ul className="building__properties">
                <li>Liczba pokoi: <span className="building__properties-value">{floor.rooms.length}</span></li>
                <li>Oświetlenie  : <span className="building__properties-value">{floor.light}</span></li>
                <li>Moc oswietlenia : <span className="building__properties-value">{floor.lightPower.toFixed(2)}</span></li>
                <li>Powierzchnia : <span className="building__properties-value">{floor.area}</span></li>
                <li>Ogrzewanie : <span className="building__properties-value">{floor.heating}</span></li>
                <li>Kubatura : <span className="building__properties-value">{floor.cube}</span></li>
              
            </ul>
   
    
             <div className='floors_list'>
                {roomsList}
            </div>
            <div className="buttons_container">
                <button className="floor_button" onClick={props.onClick}><Link to="newroom">Dodaj pokój</Link></button>
                <button className="floor_button red" onClick={props.handleDeleteButton}>Usuń piętro</button>
            </div>


        </div>
    )
} export default Floor;
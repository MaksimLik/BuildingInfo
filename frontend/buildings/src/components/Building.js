import '../styles/Building.css'
import { Routes, Route, Link } from 'react-router-dom';


function Building(props) {
    const data = props.data

    let rooms_number = 0
    if (data.floors.length > 0) {
        for (let i = 0; i < data.floors.length; i++) {
            rooms_number += data.floors[i].rooms.length
        }
    }

    return(
        <div className="building">
            <h2 className="building__name">{data.name}</h2>
            <ul className="building__properties">
                <li>Liczba pięter : <span className="building__properties-value">{data.floors.length}</span></li>
                <li>Liczba pokoi: <span className="building__properties-value">{rooms_number}</span></li>
                <li>Oświetlenie  : <span className="building__properties-value">{data.light}</span></li>
                <li>Moc oswietlenia : <span className="building__properties-value">{data.lightPower.toFixed(2)}</span></li>
                <li>Powierzchnia : <span className="building__properties-value">{data.area}</span></li>
                <li>Ogrzewanie : <span className="building__properties-value">{data.heating}</span></li>
                <li>Kubatura : <span className="building__properties-value">{data.cube}</span></li>
            </ul>
            

            <button className="buildings_details__button" onClick={props.onClick}><Link to="/building-details">Szczegóły</Link></button>

        </div>
    )

}

export default Building;    
import { useState, useEffect, useRef } from "react"
import {Link, Route, Routes} from 'react-router-dom'
import { Button, Modal } from 'react-bootstrap'
import NewFloorForm from "./NewFloorForm"
import Floor from "./Floor"
import NewRoomForm from "./NewRoomForm"
import "../styles/BuildingDetails.css"
import "../styles/Popup.css"



function BuildingDetails(props) {

    const [showModal, setShowModal] = useState(false)
    const [choosenFloor, setChoosenFloor] = useState({})

    const inputRef = useRef(null);

    const [errorMessage, setErrorMessage] = useState("")
    const [successSubmit, setSuccessSubmit] = useState("")
        
    const [threshold, setThreshold] = useState(10);

    function handleChange(event) {
        setThreshold(event.target.value);
        inputRef.current.focus();
      }


    function handleDelete() {
        setShowModal(true)
    }
  
   async function handleConfirm(id) {
      // Perform delete action here
    await fetch(`http://localhost:8080/api/v1/building/${id}`, {
        method: 'DELETE',  
    }).catch(error => console.error(error));
        setShowModal(false);

        window.location.reload();
    }
  
    function handleCancel() {
        setShowModal(false)
    }

    function handleAddRoomButton(id) {
        setChoosenFloor(id)
    }

    async function deleteFloor(id) {

        await fetch(`http://localhost:8080/api/v1/floor/${id}`, {
            method: 'DELETE'
        })
        fetch(`http://localhost:8080/api/v1/building/${props.data.id}`)
        .then(response => response.json())
        .then(res => setData(res));

    }

    async function deleteRoom(id) {
 
        await fetch(`http://localhost:8080/api/v1/room/${id}`, {
            method: 'DELETE'
        })
        fetch(`http://localhost:8080/api/v1/building/${props.data.id}`)
        .then(response => response.json())
        .then(res => setData(res));
    }



    
    const [data, setData] = useState([])
  


     useEffect(() => {
     fetch(`http://localhost:8080/api/v1/building/${props.data.id}`)
      .then(response => response.json())
      .then(res => setData(res));
  }, []);



      let floorsList = []

      if (data.length !== 0) {
        floorsList = data.floors.map(floor => (
            <Floor 
                key={floor.id}
                data={floor}
                onClick={() => {setChoosenFloor(floor.id)}}
                handleDeleteButton={() => {deleteFloor(floor.id)}}
                handleDeleteRoomButton={(id) => {deleteRoom(id)}}
                threshold={threshold}
            />
            ))
      }   


    function BuildingDetail() {
        return (
            <>
            <h1 className="main_heading">{data.name}</h1>
        
            <label >
                Próg przegrzenia
            <input type="number" value={threshold} onChange={handleChange}  style={{'marginLeft': '20px'}}/>
            </label>
            <br></br>
            <br></br>
  
            <button className="button_building_details"><Link to="/building-details/newfloor">Dodaj pietro</Link></button>
            <button className="button_building_details red" onClick={handleDelete}>Usuń budynek</button>
            <Modal show={showModal} onHide={handleCancel} className="modal_container">
                <Modal.Header  closeButton>
                    <Modal.Title className="modal_heading">Usuwanie budynku</Modal.Title>
                </Modal.Header>
                <Modal.Body>Czy napewno chcesz usunąć ten budynek?</Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleCancel}>
                    Przerwij
                    </Button>
                    <Link to="/">
                        <Button variant="primary" onClick={() =>handleConfirm(data.id)}>
                            Usuń    
                        </Button> 
                    </Link>
                </Modal.Footer>
            </Modal>
            <div className="floor_list">
                {floorsList}   
            </div>
            </>
        )
    }
  

    return (
        <>            
            <Routes>
                <Route path="" element={<BuildingDetail/>}/>
                <Route path="/newfloor" element={<NewFloorForm id={data.id}/>} />
                <Route path="/newroom" element={<NewRoomForm id={choosenFloor}/>} />
            </Routes>
            </>
        )
}
export default BuildingDetails;




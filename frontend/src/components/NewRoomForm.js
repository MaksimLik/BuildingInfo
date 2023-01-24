import React, {useState} from "react";
import "../styles/NewBuildingFrom.css"

function NewRoomForm(props) {


    const [formData, setFormData] = useState({
        name: '',
        area: '',
        cube: '',
        heating: '',
        light: ''
    });

    const [errorMessage, setErrorMessage] = useState("")
    const [successSubmit, setSuccessSubmit] = useState("")
        

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        
        setFormData({
            ...formData,
            [name]: value
        });
    }

    const handleSubmit = (event) => {
        event.preventDefault();

        if (formData.name.trim() !== "" && 
            formData.area.trim() !== "" && 
            formData.cube.trim() !== "" && 
            formData.heating.trim() !== "" &&
            formData.light.trim() !== "") {
            setErrorMessage("")
            fetch(`http://localhost:8080/api/v1/floor/${props.id}/room`, {
                method: 'POST',
                body: JSON.stringify(formData),
                headers: { 'Content-Type': 'application/json' }
            })
            .then(res => res.json())
            .then(data => console.log(data))
            .catch(error => console.error(error));
            setFormData({
                name: '',
                area: '',
                cube: '',
                heating: '',
                light: ''
            })

            setSuccessSubmit(`Dodano pokój o nazwie: ${formData.name}`    
            )

        } else {
            setErrorMessage("Wypełnij wszystkie pola")
            setSuccessSubmit("")   
        }

    }

    return (
        <>
          <div className="new_building_container">
            <h1>Dodaj nowy pokój</h1>
            <p className="error_message">{errorMessage}</p>
            <form onSubmit={handleSubmit} className="form">
                <label>
                    Nazwa:
                    <input type="text" name="name" value={formData.name} onChange={handleInputChange} />
                </label>
                <br></br>
                <label>
                    Powierzchnia:
                    <input type="number" name="area" value={formData.area} onChange={handleInputChange} />
                </label>
                <br></br>
                <label>
                    Kubatura:
                    <input type="number" name="cube" value={formData.cube} onChange={handleInputChange} />
                </label>
                <br></br>
                <label>
                    Ogrzewanie:
                    <input type="number" name="heating" value={formData.heating} onChange={handleInputChange} />
                </label>
                <br></br>
                <label>
                    Oświetlenie:
                    <input type="number" name="light" value={formData.light} onChange={handleInputChange} />
                </label>
            
                <br></br>
                <br></br>
                <button type="submit" class="form__button">Dodaj</button>
                <br></br>
                <br></br>
                <p className="success_message">{successSubmit}</p>
            </form>
          </div>
        </>
      
    )
}
export default NewRoomForm;
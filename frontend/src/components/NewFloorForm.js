import React, {useState} from "react";
import "../styles/NewBuildingFrom.css"

function NewFloorForm(props) {


    const [formData, setFormData] = useState({
        name: ''
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

        if (formData.name.trim() !== "" ) {
            setErrorMessage("")
            fetch(`http://localhost:8080/api/v1/building/${props.id}/floor`, {
                method: 'POST',
                body: JSON.stringify(formData),
                headers: { 'Content-Type': 'application/json' }
            })
            .then(res => res.json())
            .then(data => console.log(data))
            .catch(error => console.error(error));
            setFormData({
                name: ''
            })

            setSuccessSubmit(`Dodano piętro o nazwie: ${formData.name}`    
            )

        } else {
            setErrorMessage("Wypełnij to pole")
            setSuccessSubmit("")   
        }

    }

    return (
        <>
          <div className="new_building_container">
            <h1>Dodaj nowe piętro</h1>
            <form onSubmit={handleSubmit} className="form">
                <p className="error_message">{errorMessage}</p>
                <label>
                    Nazwa:
                    <input type="text" name="name" value={formData.name} onChange={handleInputChange} />
                </label>
                <br></br>
                <br></br>
                <button type="submit" className="form__button">Dodaj</button>
                <br></br>
                <br></br>
                <p className="success_message">{successSubmit}</p>
            </form>
          </div>
        </>
      
    )
}
export default NewFloorForm;
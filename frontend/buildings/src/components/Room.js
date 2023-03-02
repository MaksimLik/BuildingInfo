

function Room(props) {
    const data = props.data

    let heating = data.heating / data.cube;
    const red = heating > props.threshold ? ' red' : '';

    return(
        <div className={"building room" +  red}>
        <h3 className="building__name room " >{data.name}</h3>
        <ul className="building__properties room ">
            <li>Oświetlenie  : <span className="building__properties-value room">{data.light}</span></li>
            <li>Powierzchnia : <span className="building__properties-value room">{data.area}</span></li>
            <li>Ogrzewanie : <span className="building__properties-value room">{data.heating}</span></li>
            <li>Kubatura : <span className="building__properties-value room">{data.cube}</span></li>
            <li>Moc oświetlenia : <span className="building__properties-value room">{data.lightPower.toFixed(2)}</span></li>
        </ul>
        <button className="buildings_details__button" onClick={props.onClick}>Usuń</button>

    </div>
       
       
    )
} export default Room
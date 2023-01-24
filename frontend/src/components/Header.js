import { Link } from 'react-router-dom';


function Header() {
    return(

        <header className='header'>
            <nav className='menu'>
                <div className='menu__logo'>
                    {/* <Link to="/"><img src="images/building_logo.png"/></Link>  */}
                    <img src="images/logo1.png" />
                    <img src="images/logo2.png" className='rotate_left'/>
                    <img src="images/logo3.png" className='rotate_right'/>
                </div>
                <ul className='menu__list'>
                    <li className='menu__item'> <Link to="/">Wszystkie budynki</Link></li>
                    <li className='menu__item'> <Link to="/new-buildings">Dodaj nowy budynek</Link></li>
                </ul>  
            </nav>
     </header>

    )

}
export default Header;

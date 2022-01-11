import React, {useEffect, useState} from "react";

import "../StyleSheets/PropertyFilters.css";
import menuIcon from "../Images/Hamburger_icon.svg.png";
import axios from "axios";

import { Slider, Handles, Tracks } from 'react-compound-slider'
import {number} from "prop-types";

const PropertyFilters = (props) => {

    const baseURL = "http://localhost:8080/properties/filter";
    let interiors = ["Furnished", "Upholstered", "Unfurnished"];

    const [navBar,setNavBar] = useState(true);
    const [type, setType] = useState("");
    const [interior, setInterior] = useState("");
    const [city, setCity] = useState("Amsterdam");
    const [aproxSize, setAproxSize] = useState(0);
    const [minPrice, setMinPrice] = useState(100);
    const [maxPrice, setMaxPrice] = useState(200);
    const [submitted, setSubmitted] = useState(false);

    useEffect(() => {
        document.getElementById("sidebar").style.width = "60px";
        document.getElementById("apply-btn").style.visibility = "hidden";
        document.getElementById("additional").style.visibility = "hidden";
    }, [])

    function toggleNavBar() {
        setNavBar(!navBar)
        if(navBar) {
            document.getElementById("sidebar").style.width = "350px";
            document.getElementById("apply-btn").style.visibility = "visible";
            document.getElementById("additional").style.visibility = "visible";
        }
        else {
            document.getElementById("sidebar").style.width = "60px";
            document.getElementById("apply-btn").style.visibility = "hidden";
            document.getElementById("additional").style.visibility = "hidden";
        }
    }

    const handleType = (e) => {
        setType(e.target.value);
        setSubmitted(false);
    }
    const handleInterior = (e) => {
        setInterior(e.target.value);
        setSubmitted(false);
    }
    const handleCity = (e) => {
        setCity(e.target.value);
        setSubmitted(false);
    }
    const handleMin = (e) => {
        setMinPrice(e.target.value);
        setSubmitted(false);
    }
    const handleMax = (e) => {
        setMaxPrice(e.target.value);
        setSubmitted(false);
    }
    const handleSize = (e) => {
        setAproxSize(e.target.value);
        setSubmitted(false);
    }

    const applyFilters = () => {
        axios.get(baseURL, {
            params : {
                "type" : type,
                "location" : city,
                "aproxSize" : aproxSize,
                "minPrice" : minPrice,
                "maxPrice" : maxPrice,
                "interior" : interior
            }
        }).then((response) => {
            if(response.status === 200) {
                props.properties(response.data)
            }
        })
    }

    return (
        <div className={"wrapper"}>
            <div id={"sidebar"}>
                <img onClick={() => {toggleNavBar()}} id={"menu-icon"} src={menuIcon}/>
                <div id={"additional"}>
                    <div className={"city"}>
                        <p id={"city-lbl"}><b>City</b></p>
                        <select onChange={handleCity} name={"cities"} id={"cities"}>
                            <option value={"Amsterdam"}>Amsterdam</option>
                            <option value={"Rotterdam"}>Rotterdam</option>
                            <option value={"Den Haag"}>Den Haag</option>
                            <option value={"Utrecht"}>Utrecht</option>
                            <option value={"Eindhoven"}>Eindhoven</option>
                            <option value={"Tilburg"}>Tilburg</option>
                            <option value={"Almere"}>Almere</option>
                            <option value={"Groningen"}>Groningen</option>
                            <option value={"Breda"}>Breda</option>
                            <option value={"Nijmegen"}>Nijmegen</option>
                            <option value={"Enschede"}>Enschede</option>
                            <option value={"Apeldoorn"}>Apeldoorn</option>
                            <option value={"Haarlem"}>Haarlem</option>
                            <option value={"Arnhem"}>Arnhem</option>
                            <option value={"Zaanstad"}>Zaanstad</option>
                            <option value={"Amersfoort"}>Amersfoort</option>
                            <option value={"Haarlemmermeer"}>Haarlemmermeer</option>
                            <option value={"’s-Hertogenbosch"}>’s-Hertogenbosch</option>
                            <option value={"Zoetermeer"}>Zoetermeer</option>
                            <option value={"Zwolle"}>Zwolle</option>
                            <option value={"Other"}>Other</option>
                        </select>
                    </div>
                    <div className={"price"}>
                        <label><b>Price</b></label>
                        <br/>
                        <label htmlFor={"min-price"}>From:</label>
                        <select onChange={handleMin} name={"min-price"} id={"min-price"}>
                            <option value={100}>100€</option>
                            <option value={200}>200€</option>
                            <option value={300}>300€</option>
                            <option value={400}>400€</option>
                            <option value={500}>500€</option>
                            <option value={600}>600€</option>
                            <option value={700}>700€</option>
                            <option value={800}>800€</option>
                            <option value={900}>900€</option>
                            <option value={1000}>1000€</option>
                            <option value={1500}>1500€</option>
                            <option value={2000}>2000€</option>
                            <option value={3000}>3000€</option>
                            <option value={5000}>5000€</option>
                        </select>
                        <label htmlFor={"max-price"}>To:</label>
                        <select onChange={handleMax} name={"max-price"} id={"max-price"}>
                            <option value={200}>200€</option>
                            <option value={300}>300€</option>
                            <option value={400}>400€</option>
                            <option value={500}>500€</option>
                            <option value={600}>600€</option>
                            <option value={700}>700€</option>
                            <option value={800}>800€</option>
                            <option value={900}>900€</option>
                            <option value={1000}>1000€</option>
                            <option value={1500}>1500€</option>
                            <option value={2000}>2000€</option>
                            <option value={3000}>3000€</option>
                            <option value={5000}>5000€</option>
                            <option value={100000}>&gt;5000€</option>
                        </select>
                    </div>
                    <div className={"type"}>
                        <div className={"additional-type-label"}>
                            <label htmlFor="type"><b>Property Type</b></label>
                        </div>
                        <input type={"radio"} value="Room" onChange={handleType} required={true} name={"type"} id={"type1"}/>
                        <label htmlFor="type1"><b>Room</b></label>
                        <input type={"radio"} value="Studio" onChange={handleType} required={true} name={"type"} id={"type2"}/>
                        <label htmlFor="type2"><b>Studio</b></label>
                        <input type={"radio"} value="Apartment" onChange={handleType} required={true} name={"type"} id={"type3"}/>
                        <label htmlFor="type3"><b>Apartment</b></label>
                    </div>
                    <div className={"interior"}>
                        <div className={"additional-interior-label"}>
                            <label htmlFor="interior"><b>Property Interior   </b></label>
                        </div>
                        <input type={"radio"} value={interiors[0]} id={"interior1"} onChange={handleInterior} required={true} name={"interior"}/>
                        <label htmlFor="interior1"><b>Furnished</b></label>
                        <br/>
                        <input type={"radio"} value={interiors[1]} id={"interior2"} onChange={handleInterior} required={true} name={"interior"}/>
                        <label htmlFor="interior2"><b>Upholstered</b></label>
                        <br/>
                        <input type={"radio"} value={interiors[2]} id={"interior3"} onChange={handleInterior} required={true} name={"interior"}/>
                        <label htmlFor="interior3"><b>Unfurnished</b></label>
                    </div>
                    <div className={"size"}>
                        <label htmlFor="size"><b>Property Size in m²</b></label>
                        <input id={"size-number"} type={"number"} onChange={handleSize}/>
                    </div>
                </div>
                <button onClick={applyFilters} id={"apply-btn"}>Apply</button>
            </div>
        </div>
    )
}
export default PropertyFilters
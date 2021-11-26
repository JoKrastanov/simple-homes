import React from "react";
import Popup from "reactjs-popup";

import "../StyleSheets/PropertyContainer.css";

import Image from "../Images/5089528.jpg";


function PropertyContainer(p) {
    return (
        <div className={"property-container"}>
            <div className={"property-container-image"}>
                <img id={"image"} src={Image}/>
            </div>
            <div className={"property-container-info"}>
                <div className={"property-container-header"}>
                    <h2>{p.type} <br/> {p.address}</h2>
                </div>
                <div className={"property-container-details-address"}>
                    <p>{p.postalCode} {p.city}</p>
                </div>
                <div className={"property-container-details-price"}>
                    <p>{p.price}$</p>
                </div>
                <div className={"property-container-additional-details"}>
                    <p>{p.size}m² • {p.rooms} • {p.interior}</p>
                </div>
            </div>
        </div>
    );
}

export default PropertyContainer
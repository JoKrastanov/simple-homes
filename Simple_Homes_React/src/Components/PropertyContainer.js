import React, {useEffect, useState} from "react";
import Popup from "reactjs-popup";

import "../StyleSheets/PropertyContainer.css";

import Image from "../Images/5089528.jpg";
import {Link} from "react-router-dom";


function PropertyContainer(props) {
    return (
            <div className={"property-container"}>
                <Link to={`/Property/${props.p.id}`} style={{ textDecoration: 'none' }}>
                    <div className={"property-container-image"}>
                        <img id={"image"} src={Image}/>
                    </div>
                    <div className={"property-container-info"}>
                        <div className={"property-container-header"}>
                            <h2>{props.p.type} <br/> {props.p.address}</h2>
                        </div>
                        <div className={"property-container-details-address"}>
                            <p>{props.p.postalCode} {props.p.city}</p>
                        </div>
                        <div className={"property-container-details-price"}>
                            <p>{props.p.price}$</p>
                        </div>
                        <div className={"property-container-additional-details"}>
                            <p>{props.p.size}m² • {props.p.rooms} • {props.p.interior}</p>
                        </div>
                    </div>
                </Link>
        </div>
    );
}

export default PropertyContainer
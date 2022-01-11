import React, {useEffect, useState} from "react";
import axios from "axios";
import Cookies from "universal-cookie/lib";
import imgPlaceholder from "../Images/profile-icon-male-user-person-avatar-symbol-vector-20910833.png";
import "../StyleSheets/ScheduleViewing.css"
import SchedulePopup from "./SchedulePopup";
import {Link} from "react-router-dom";

function ScheduleViewing(props) {

    const baseUrl = "http://localhost:8080/accounts/" + props.publisher;

    const cookie = new Cookies();
    const [owner, setOwner] = useState(null);
    const [popupOpened, setPopupOpened] = useState(false);

    const togglePopup = () => {
        setPopupOpened(!popupOpened)
    }

    useEffect(  () => {
            axios
            .get(baseUrl, {
                headers: {
                    'Authorization': cookie.get("authToken")
                }
            })
            .then((response) => {
                if (response.status === 200) {
                    setOwner(response.data)
                }
            });
    }, [])
    if(owner != null) {return (
        <>
            <div className={"schedule"}>
                <img src={imgPlaceholder}/>
                <p>{owner.name}</p>
                <div id={"contact-details"}>
                    <p id={"contact-title"}>Contact owner</p>
                    <p>Phone: {owner.phoneNumber}</p>
                    <p>Email: {owner.email}</p>
                </div>
                <button id={"schedule-button"} onClick={togglePopup}>Schedule Viewing</button>
            </div>
            {(popupOpened) ? <div className={"schedule-popup"}>
                 <SchedulePopup onChange={togglePopup} property={props.property} publisher={props.publisher} user={props.user}/>
            </div>: ''}
        </>

    )}
    else {return (<div>To schedule a viewing please <Link to={"/LogIn"}>Log In</Link> first</div>)}
}

export default ScheduleViewing
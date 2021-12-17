import React from 'react';

import "../StyleSheets/NavBar.css";
import logo from "../Images/Capture.PNG"
import profileLogo from "../Images/profile-icon-male-user-person-avatar-symbol-vector-20910833.png";

import {
    Link,
} from "react-router-dom";




export default function NavBar(props) {

    const isLoggedIn = () => {
        if (localStorage.getItem('authToken') != null) {
            return (
                <div>
                    <li>
                    <Link to="/Profile">
                        <div id={"profile-logo-container"}>
                            <img id={"profile-logo-img"} src={profileLogo}/>
                        </div>
                    </Link>
                </li>
                    <li>
                        <button onClick={props.logOut}  id={"log-out"}>Log Out</button>
                    </li>
                </div>
            );
        }
        else {
            return (
            <div>
                <li className={"NavBar-items-right-item"}>
                    <Link to="/LogIn">Log In</Link>
                </li>
                <li className={"NavBar-items-right-item"}>
                    <Link to="/Register">Register</Link>
                </li>
            </div>
            );
        }
    }
    return (
        <div className={"NavBar"}>
                <div>
                    <ul className={"NavBar-items"}>
                        <li>
                            <img id={"logo"} src={logo}/>
                        </li>
                        <li>
                            <Link to="/">Home</Link>
                        </li>
                        <li id={"properties"}>
                            <Link
                                to="/Properties">Properties</Link>
                        </li>
                        <li>
                            <Link to="/Upload">Upload a property</Link>
                        </li>
                        <div className={"NavBar-items-right"}>
                            {isLoggedIn()}
                        </div>
                    </ul>
                </div>
        </div>
    );




}

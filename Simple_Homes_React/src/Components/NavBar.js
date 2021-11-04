import React from 'react';

import Overview from "./Overview";
import Properties from "./Properties"
import LogIn from "./LogIn";
import Profile from "./Profile";
import Register from "./Register";
import Home from "./Home";

import "../StyleSheets/NavBar.css";
import logo from "../Images/Capture.PNG"
import profileLogo from "../Images/profile-icon-male-user-person-avatar-symbol-vector-20910833.png";
import welcomeImage from "../Images/wallpaperflare.com_wallpaper.jpg";

import {useState, useEffect} from "react";

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
} from "react-router-dom";

import {
    Dropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem
} from "reactstrap";


export default function NavBar() {

    const [loggedIn, setLoggedIn] = useState(false);

    const logIn = () => {
        setLoggedIn(true);
    }
    const logOut = () => {
        setLoggedIn(false);
    }


    const onMouseEnter = () => {
        document.getElementById("menu").style.visibility = "visible";
    }

    const onMouseLeave = () => {
        document.getElementById("menu").style.visibility = "hidden";
    }

    const isLoggedIn = () => {
        if (loggedIn) {
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
                        <button onClick={logOut}  id={"log-out"}>Log Out</button>
                    </li>
                </div>
            );
        }
        else {
            return (
            <div>
                <li className={"NavBar-items-right-item"}>
                    <Link to="LogIn">Log In</Link>
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
            <Router>
                <div>
                    <ul className={"NavBar-items"}>
                        <li>
                            <img id={"logo"} src={logo}/>
                        </li>
                        <li>
                            <Link to="/Home">Home</Link>
                        </li>
                        <li>
                            <Dropdown onMouseOver={onMouseEnter} onMouseLeave={onMouseLeave}>
                                <DropdownToggle className={"drop-down"}>
                                    <Link
                                        className={"drop-down"}
                                        to="/Properties">Properties</Link>
                                </DropdownToggle>
                                <DropdownMenu id={"menu"} className={"drop-down-menu"}>
                                    <DropdownItem className={"drop-down-item"}>Rent</DropdownItem>
                                    <DropdownItem className={"drop-down-item"}>Buy</DropdownItem>
                                </DropdownMenu>
                            </Dropdown>
                        </li>
                        <li>
                            <Link to="/Overview">Upload a property</Link>
                        </li>
                        <li>
                            <Link to="/Overview">Users(For development)</Link>
                        </li>
                        <div className={"NavBar-items-right"}>
                            {isLoggedIn()}
                        </div>
                    </ul>
                    <Switch>
                        <Route path="/Overview">
                            <Overview/>
                        </Route>
                        <Route path="/Properties">
                            <Properties/>
                        </Route>
                        <Route path="/LogIn">
                            <LogIn loggedIn = {loggedIn} onChange={logIn}/>
                        </Route>
                        <Route path="/Profile">
                            <Profile/>
                        </Route>
                        <Route path="/Register">
                            <Register/>
                        </Route>
                        <Route path="/Home">
                            <Home/>
                        </Route>
                    </Switch>
                </div>
            </Router>
            <div id={"welcome"}>
                <img id={"welcomeImage"} src={welcomeImage}/>
            </div>
        </div>
    );
}

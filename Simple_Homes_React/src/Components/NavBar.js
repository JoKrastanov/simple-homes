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
import {useCookies} from "react-cookie";
import UploadProperty from "./UploadProperty";



export default function NavBar() {

    const[cookie, setCookie] = useCookies();

    const logIn = (token, user) => {
        setCookie("authToken", token)
        setCookie("user", user)
    }
    const logOut = () => {
        setCookie("authToken", "")
        setCookie("user", 0)
    }

    const isLoggedIn = () => {
        if (cookie.authToken != "") {
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
                            <Link
                                className={"drop-down"}
                                to="/Properties">Properties</Link>
                        </li>
                        <li>
                            <Link to="/Upload">Upload a property</Link>
                        </li>
                        <div className={"NavBar-items-right"}>
                            {isLoggedIn()}
                        </div>
                    </ul>
                    <Switch>
                        <Route path="/Upload">
                            <UploadProperty token = {cookie.authToken} user = {cookie.user}/>
                        </Route>
                        <Route path="/Properties">
                            <Properties token = {cookie.authToken} user = {cookie.user}/>
                        </Route>
                        <Route path="/LogIn">
                            <LogIn loggedIn = {cookie} onChange={logIn}/>
                        </Route>
                        <Route path="/Profile">
                            <Profile token = {cookie.authToken} user = {cookie.user}/>
                        </Route>
                        <Route path="/Register">
                            <Register/>
                        </Route>
                        <Route path="/Home">
                            <Home token = {cookie.authToken} user = {cookie.user}/>
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

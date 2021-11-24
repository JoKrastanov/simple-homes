import React, {useEffect, useState} from 'react';

import "../StyleSheets/LogIn.css";
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
    useHistory
} from "react-router-dom";
import {useCookies} from "react-cookie";

import axios from "axios";
import PropertyContainer from "./PropertyContainer";

import {use} from "express/lib/router";

function LogIn(props) {

    const baseURL = "http://localhost:8080/login";
    const logInURL = "http://localhost:8080/accounts/login";

    let history = useHistory();

    const [error, setError] = useState(false);

    const redirectToRegister = () => {
        history.push("/Register");
    }

    const logIn = () => {
        let tokenValue = "";
        let loggedUser = 0
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value

        axios
            .post(baseURL, {
                email : email,
                password : password
            })
            .then((response) => {
                if (response.status === 200) {
                    tokenValue = response.data.Authorization;
                    verifyToken(tokenValue, email,password, loggedUser);
                }
                else {
                    setError(true);
                }
            })
    }

    const verifyToken = (token, email, password, user) => {
        axios
            .get(logInURL, {
                headers : {
                    'Authorization' : token
                },
                params : {
                    email : email,
                    password : password
                }
            })
            .then((response) => {
                if (response.status === 200) {
                    user = response.data.id;
                    props.onChange(token, user);
                    console.log(token + " " + user)
                    history.push("/Home");
                }
            });
    }


    return (
        <div className={"LogIn"}>
            <div className="container">
                <label htmlFor="uname"><b>Email</b></label>
                <input type="text" placeholder="Enter Email" name="uname" id={"email"} required/>

                <label htmlFor="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" id={"password"} required/>
                {!error ? <></> : <p id={"login-fail"}>Incorrect username or password! Please try again.</p>}
                <button onClick={logIn}>Login</button>
                <label>
                    <input type="checkbox" name="remember"/> Remember me
                </label>
                    <p>Don't have an account? <a className={"register-button"} onClick={redirectToRegister} >Register here</a></p>
            </div>
            <div className="container">
                <span className="psw">Forgot <a href="#">password?</a></span>
            </div>
        </div>
    );
}
export default LogIn;
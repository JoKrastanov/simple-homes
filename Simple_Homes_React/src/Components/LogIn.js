import React from 'react';

import "../StyleSheets/LogIn.css";
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
    useHistory
} from "react-router-dom";

import axios from "axios";

function LogIn(props) {

    const baseURL = "http://localhost:8080/accounts/login/";
    let history = useHistory();

    const redirectToRegister = () => {
        history.push("/Register");
    }

    const logIn = () => {
        axios
            .post(baseURL, {
                "email" : document.getElementById("email").value,
                "password" : document.getElementById("password").value
            })
            .then((response) => {

                if (response.status === 200) {
                    props.onChange(true);
                    history.push("/Overview");}
            });
    }


    return (
        <div className={"LogIn"}>
            <div className="container">
                <label htmlFor="uname"><b>Email</b></label>
                <input type="text" placeholder="Enter Email" name="uname" id={"email"} required/>

                <label htmlFor="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" id={"password"} required/>

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
import React from "react";
import axios from "axios";

import {useHistory} from "react-router-dom";

import "../StyleSheets/Register.css";

const Register = () => {

    const baseURL = "http://localhost:8080/accounts";
    let history = useHistory();

    const RegisterUser = () => {
        let firstPass = document.getElementById("psw").value;
        let secondPass = document.getElementById("repPsw").value;
        if(firstPass === secondPass) {
            axios
                .post(baseURL, {
                "password" : document.getElementById("psw").value,
                "name" : document.getElementById("name").value,
                "email" : document.getElementById("email").value,
                "phoneNumber" : document.getElementById("phone").value
                })
                .then((response) => {
                    if (response.status === 201) {
                        history.push("/Overview");}
                });
        }
    }

    return (
        <div className={"Register"}>
            <div className="container">
                <label htmlFor="name"><b>Name</b></label>
                <input type="text" placeholder="Enter Your Full Name" name="name" id={"name"} required/>

                <label htmlFor="email"><b>Email</b></label>
                <input type="text" placeholder="Enter Email" name="email" id={"email"} required/>

                <label htmlFor="phone"><b>Phone number</b></label>
                <input type="text" placeholder="Enter Phone number" name="phone" id={"phone"} required/>

                <label htmlFor="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" id={"psw"} required/>

                <label htmlFor="repPsw"><b>Password</b></label>
                <input type="password" placeholder="Repeat Password" name="repPsw" id={"repPsw"} required/>

                <button type="button" onClick={RegisterUser}>Register</button>
            </div>
        </div>
    );
}

export default Register;
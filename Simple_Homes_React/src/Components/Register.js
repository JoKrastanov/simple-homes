import React, {useState} from "react";
import axios from "axios";

import {useHistory} from "react-router-dom";

import "../StyleSheets/Register.css";

const Register = () => {

    const baseURL = "http://localhost:8080/accounts";
    let history = useHistory();
    const [name, setName] = useState();
    const [password, setPassword] = useState();
    const [repPassword, setRepPassword] = useState();
    const [email, setEmail] = useState();
    const [phone, setPhone] = useState();

    const [submitted, setSubmitted] = useState(false);
    const [showErr, setShowErr] = useState(true);
    const [error, setError] = useState(false);

    const handleName = (e) => {
        setName(e.target.value)
        setSubmitted(false);
    }

    const handlePassword = (e) => {
        setPassword(e.target.value)
        setSubmitted(false);
    }

    const handleEmail = (e) => {
        setEmail(e.target.value)
        setSubmitted(false);
    }

    const handlePhone = (e) => {
        setPhone(e.target.value)
        setSubmitted(false);
    }

    const handleRepPassword = (e) => {
        setRepPassword(e.target.value)
        setSubmitted(false);
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        if(password === repPassword) {
            axios
                .post(baseURL, {
                password : password,
                name : name,
                username : email,
                phoneNumber : phone
                })
                .then((response) => {
                    if (response.status === 200) {
                        history.push("/LogIn");}
                    setShowErr(false);
                });
            if(showErr) {setError(true)}
        }
    }

    return (
        <div className={"Register"}>
            <form onSubmit={handleSubmit}>
                <div className="container">
                    <label htmlFor="name"><b>Name</b></label>
                    <input type="text" placeholder="Enter Your Full Name" name="name" id={"name"} value={name} onChange={handleName} required/>

                    <label htmlFor="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="email" id={"email"} value={email} onChange={handleEmail} required/>

                    <label htmlFor="phone"><b>Phone number</b></label>
                    <input type="text" placeholder="Enter Phone number" name="phone" id={"phone"} value={phone} onChange={handlePhone} required/>

                    <label htmlFor="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" id={"psw"} value={password} onChange={handlePassword} minLength={8} required/>

                    <label htmlFor="repPsw"><b>Repeat Password</b></label>
                    <input type="password" placeholder="Repeat Password" name="repPsw" id={"repPsw"} value={repPassword} onChange={handleRepPassword} required/>
                    {!error ? <></> : <p id={"err"}>This email has already been taken!</p>}
                    <button id={'register'} type="submit">Register</button>
                </div>
            </form>
        </div>
    );
}

export default Register;
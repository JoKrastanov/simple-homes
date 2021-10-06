import React from "react";

import "../StyleSheets/Register.css";

const Register = () => {
    return (
        <div className={"Register"}>
            <div className="container">
                <label htmlFor="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="uname" required/>

                <label htmlFor="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required/>

                <button type="submit">Login</button>
            </div>

        </div>
    );
}

export default Register;
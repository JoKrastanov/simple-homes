import '../StyleSheets/App.css';
import React, { useState, useEffect } from 'react';

import axios from "axios";
import {Link, Redirect, Route, Router, Switch, useHistory} from "react-router-dom";
import ReactDOM from "react-dom";

export default function Overview() {


    //Constants
    const [post, setPost] = useState(null);
    const baseURL = "http://localhost:8080/accounts/";


    //Hooks
    useEffect(() => {
        axios.get(baseURL).then((response) => {
            setPost(response.data);
            console.log(response.data);
        });
    }, []);


    //Functions
    function createPost() {
        axios
            .post(baseURL, {
                name: document.getElementById("name").value,
                email: document.getElementById("email").value,
                phoneNumber: document.getElementById("phone").value,
                password: document.getElementById("password").value
            })
            .then((response) => {
                window.location.reload(false);
            });
    }

    function updatePost() {
        axios
            .put(baseURL, {
                id: document.getElementById("id").value,
                name: document.getElementById("name").value,
                email: document.getElementById("email").value,
                phoneNumber: document.getElementById("phone").value,
                password: document.getElementById("password").value
            })
            .then((response) => {
                window.location.reload(false);
            });
    }

    function deletePost() {
        axios
            .delete(baseURL + document.getElementById("id").value)
            .then(() => {
                window.location.reload(false);
            });
    }


    if (!post) return null;


    //Output
    return (
        <div className={"DataOverview"}>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Password</th>
                </tr>
                {post.map(p => (
                    <tr>
                        <td>{p.id}</td>
                        <td>{p.name}</td>
                        <td>{p.email}</td>
                        <td>{p.phoneNumber}</td>
                        <td>{p.password}</td>
                    </tr>
                ))}
            </table>
            <div>
                <label>ID:</label> <br/>
                <input id={"id"} type={<textarea></textarea>} required/> <br/>
                <label>Name:</label> <br/>
                <input id={"name"} type={<textarea></textarea>} required/> <br/>
                <label>Email:</label> <br/>
                <input id={"email"} type={<textarea></textarea>} required/> <br/>
                <label>Phone:</label> <br/>
                <input id={"phone"} type={<textarea></textarea>} required/> <br/>
                <label>Password</label> <br/>
                <input id={"password"} type={<textarea></textarea>} required/> <br/>
                <button onClick={createPost}>Create Post</button>
                <br/>
                <button onClick={updatePost}>Update</button>
                <button onClick={deletePost}>Delete</button>

            </div>
        </div>
    );
}
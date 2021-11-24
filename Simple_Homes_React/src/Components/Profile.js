import React, {useEffect, useState} from "react";
import axios from "axios";

import image from "../Images/ActuallyEdSheeran.jpg"
import "../StyleSheets/Profile.css";
import {useHistory} from "react-router-dom";

const Profile = (props) => {

    let authToken = props.token;
    let userId = props.user;
    const baseUrl = "http://localhost:8080/accounts/" + userId
    let history = useHistory();
    const [user, setUser] = useState();
    useEffect(() => {
        axios
            .get(baseUrl, {
                headers: {
                    'Authorization': authToken
                }
            })
            .then((response) => {
                if (response.status === 200) {
                    setUser(response.data)
                    console.log(baseUrl)
                }
            });
    }, []);


    if(authToken != "" && userId != 0 && user != null)
    {
    return (
      <div className={"profile"}>
          <div className={"profile-info"}>
              <img id={"profile-pic"} src={image}/>
              <p>{user.name}</p>
              <p>{user.email}</p>
              <p>{user.phoneNumber}</p>
              <button id={"edit-button"}>Edit Profile</button>
          </div>
        <div className={"bookmarked-properties"}>
            Bookmarks
        </div>
      </div>
    );}
    else {
        return (
      <div id={"expired-session"}>Your session has expired. Please log in again!</div>
    );}
}

export default Profile
import React, {useEffect, useState} from "react";
import axios from "axios";

import image from "../Images/ActuallyEdSheeran.jpg"
import "../StyleSheets/Profile.css";
import {Link} from "react-router-dom";
import PropertyContainer from "./PropertyContainer";

const Profile = (props) => {

    let authToken = localStorage.getItem('authToken');
    let userId = localStorage.getItem('user');
    const baseUrl = "http://localhost:8080/accounts/" + userId
    const viewingUrl = "http://localhost:8080/properties/viewing/account/" + userId
    const [user, setUser] = useState();
    const [viewings, setViewings] = useState(null);

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
                }
            });

        axios
            .get(viewingUrl, {
                headers: {
                    'Authorization': authToken
                }
            }).then((response) => {
            if (response.status === 200) {
                if(response.data.length > 0)
                {
                    setViewings(response.data)
                }
            }
        })

    }, []);


    if(authToken != "" && userId != 0 && user != null)
    {
    return (
      <div className={"profile"}>
          <div className={"profile-info"}>
              <div id={'profile-avatar'}>
                  <img id={"profile-pic"} src={image}/>
                  <p>{user.name}</p>
                  <p>{user.email}</p>
                  <p>{user.phoneNumber}</p>
              </div>
                  <div><button id={"edit-button"}>Edit Profile</button></div>
                  <button id={"delete-button"}>Delete Profile</button>

          </div>
        <div className={"bookmarked-properties"}>
            <p>Upcoming Viewings</p>
            <div id={"account-viewings"}>
                {viewings!=  null ?
                <div id={"viewing-container"}>
                    {viewings.map(p => (
                        <div className={"viewing"}>
                            <Link class={"viewing-link"} to={`/Property/${p.propertyId}`}>{p.viewingDate.split('T')[0]}</Link>
                        </div>
                    ))}
                </div> : <div className={"viewing-error"}>You do not have any upcoming viewings</div>}
            </div>
        </div>
      </div>
    );}
    else {
        return (
      <div id={"expired-session"}>Your session has expired. Please log in again!</div>
    );}
}

export default Profile
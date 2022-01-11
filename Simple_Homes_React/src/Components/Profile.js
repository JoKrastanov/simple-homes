import React, {useEffect, useState} from "react";
import axios from "axios";

import Popup from 'reactjs-popup';
import 'reactjs-popup/dist/index.css';
import image from "../Images/ActuallyEdSheeran.jpg"
import "../StyleSheets/Profile.css";
import {Link} from "react-router-dom";


const Profile = () => {

    let authToken = localStorage.getItem('authToken');
    let userId = localStorage.getItem('user');
    const url = "http://localhost:8080/accounts/"
    const baseUrl = "http://localhost:8080/accounts/" + userId
    const viewingUrl = "http://localhost:8080/properties/viewing/account/" + userId
    const [user, setUser] = useState();
    const [viewings, setViewings] = useState(null);

    const [deleteOpened, setDeleteOpened] = useState(false);
    const [editOpened, setEditOpened] = useState(false);

    const closeEdit = () => setEditOpened(false);
    const openEdit = () => {
        setEditOpened(true);
    }

    const closeDelete = () => setDeleteOpened(false);
    const openDelete = () => {setDeleteOpened(true)}
    const DeleteAcc = () => {
        axios.delete(baseUrl, {
            headers: {
                'Authorization': authToken
            }
        }).then(r => {
            if(r.status === 200) {
                localStorage.clear();
                window.location.reload();
            }
        })
    }
    const EditAcc = () => {
            axios.put(url, {
                headers: {
                    'Authorization': localStorage.getItem('authToken')
                },
                data : {
                    id : userId,
                    name: document.getElementById("name").value,
                    email: document.getElementById("email").value,
                    phoneNumber: document.getElementById("phone").value,
                    password: document.getElementById("password").value
                }
            }).then(r => {
                if(r.status === 200) {
                    window.location.reload();
                }
            })
    }

    useEffect(() => {
        console.log(baseUrl);
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


    if(authToken !== "" && userId !== 0 && user != null)
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
                  <div><button onClick={openEdit} id={"edit-button"}>Edit Profile</button></div>
              <button id={"delete-button"} onClick={openDelete}>Delete Profile</button>
              <Popup open={deleteOpened} position={"right center"}>
                  <div>
                      <p>Are you sure you want to delete your account?</p>
                      <button onClick={DeleteAcc} className={"button"}>Yes</button>
                      <button onClick={closeDelete} className={"button"}>No</button>
                  </div>
              </Popup>
              <Popup open={editOpened} position={"right center"}>
                  <div>
                      <label>Name</label>
                      <input type={"text"} id={"name"}/>
                      <label>Email</label>
                      <input type={"text"} id={"email"}/>
                      <label>Phone Number</label>
                      <input type={"text"} id={"phone"}/>
                      <label>Password</label>
                      <input type={"password"} id={"password"}/>
                      <button onClick={EditAcc} className={"button"}>Submit</button>
                      <button onClick={closeEdit} className={"button"}>Cancel</button>
                  </div>
              </Popup>
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
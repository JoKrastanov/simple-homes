import './StyleSheets/App.css';
import {BrowserRouter as Router, Switch, Route, useHistory} from "react-router-dom";
import NavBar from "./Components/NavBar";
import Home from "./Components/Home";
import LogIn from "./Components/LogIn";
import {CookiesProvider, useCookies} from "react-cookie";
import Register from "./Components/Register";
import Profile from "./Components/Profile";
import UploadProperty from "./Components/UploadProperty";
import Properties from "./Components/Properties";
import welcomeImage from "./Images/wallpaperflare.com_wallpaper.jpg";
import React from "react";
import ViewProperty from "./Components/ViewProperty";
import Cookies from "universal-cookie/lib";

function App() {

    const cookies = new Cookies();

    const logIn = (token, user) => {
        localStorage.setItem("authToken", token)
        localStorage.setItem("user", user)
        cookies.set("authToken", token)
        cookies.set("user", user)
    }
    const logOut = () => {
        cookies.set("authToken", null)
        cookies.set("user", null)
        localStorage.clear();
        window.location.reload();
    }

        return (
            <CookiesProvider>
                <Router>
                    <div className="App">
                        <NavBar logOut={logOut} token={cookies.get("authToken")}/>
                        <Switch>
                            <Route path={"/"} exact children={<Home token={cookies.get("authToken")} user={cookies.get("user")}/>}/>
                            <Route path={"/LogIn"} children={<LogIn token={cookies.get("authToken")} user={cookies.get("user")} onChange={logIn}/>}/>
                            <Route path={"/Register"} children={<Register token={cookies.get("authToken")} user={cookies.get("user")}/>}/>
                            <Route path={"/Profile"} children={<Profile token={cookies.get("authToken")} user={cookies.get("user")}/>}/>
                            <Route path={"/Upload"} children={<UploadProperty token={cookies.get("authToken")} user={cookies.get("user")}/>}/>
                            <Route path={"/Properties"} children={<Properties token={cookies.get("authToken")} user={cookies.get("user")}/>}/>
                            <Route path={`/Property/:id`} component={ViewProperty}/>

                        </Switch>
                            <img id={"welcomeImage"} src={welcomeImage}/>
                    </div>
                </Router>
            </CookiesProvider>
        );
}
export default App;


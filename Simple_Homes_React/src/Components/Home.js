import React from "react";

import "../StyleSheets/Home.css";

import Search from "./Search";

const Home = () => {
    return (
        <div className={"home"}>
            <h1>Welcome to Simple Homes</h1>
            <Search/>
        </div>
    )
}

export default Home;
import React, {useEffect, useState} from "react";
import axios from "axios";
import {Link} from "react-router-dom"

import "../StyleSheets/Properties.css";
import emailImg from "../Images/email.png";
import PropertyContainer from "./PropertyContainer";
import PropertyFilters from "./PropertyFilters";



const Properties = () => {

    //Constants
    const [post, setPost] = useState(null);

    const baseURL = "http://localhost:8080/properties";

    //Hooks
    useEffect(() => {
        axios.get(baseURL).then((response) => {
            setPost(response.data);
        });
    }, []);


    if (!post) return null
        return (
            <div className={"properties"}>
                <PropertyFilters properties={setPost}/>
                <p id={"results"}>"{post.length}" {post.length != 1 ? "results" : "result"} found</p>
                <div className={"properties-containers"}>
                    {post.map(p => (
                        <PropertyContainer key={p.id} p={p}/>
                    ))}
                < /div>
            </div>
        )
}
export default Properties
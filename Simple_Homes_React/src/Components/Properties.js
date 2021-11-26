import React, {useEffect, useState} from "react";
import axios from "axios";

import "../StyleSheets/Properties.css";
import PropertyContainer from "./PropertyContainer";

import PropertyFilters from "./PropertyFilters";
import {Link, Route, Switch, BrowserRouter} from "react-router-dom";
import Property from "./Property";
import ViewProperty from "./ViewProperty";


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
            <div className={"properties-filters"}>
                <PropertyFilters/>
            </div>
            <div className={"properties-containers"}>
                {post.map(p => (
                    <div>
                        <BrowserRouter>
                            <Link to="/Property"><PropertyContainer key={p.id} {...p}/></Link>
                            <Switch>
                                <Route path="/Property">
                                    <Property key={p.id} {...p}/>
                                </Route>
                            </Switch>
                        </BrowserRouter>
                    </div>
                    ))}
            < /div>
        </div>
    )
}
export default Properties
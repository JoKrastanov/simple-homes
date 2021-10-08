import React, {useEffect, useState} from "react";
import axios from "axios";

import "../StyleSheets/Properties.css";
import PropertyContainer from "./PropertyContainer";

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
    useHistory
} from "react-router-dom";
import ViewProperty from "./ViewProperty";
import PropertyFilters from "./PropertyFilters";

const Properties = () => {

    //Constants
    const [post, setPost] = useState(null);
    const baseURL = "http://localhost:8080/properties/";

    let history = useHistory();

    const testMethod = () => {
        history.push("/Property");
    }

    //Hooks
    useEffect(() => {
        axios.get(baseURL).then((response) => {
            setPost(response.data);
            console.log(response.data);
        });
    }, []);

    if (!post) return null
    return (
        <div className={"properties"}>
            <div className={"properties-filters"}>
                <PropertyFilters/>
            </div>
            <div className={"properties-containers"}>
                <Router>
                    {post.map(p => (
                        <>
                            <Link to={"/property"} style={{ textDecoration: 'none' }}>
                                <PropertyContainer key={p.id} {...p}/>
                            </Link>
                            <Switch>
                                <Route path={"/property"}>
                                    <ViewProperty {...p}/>
                                </Route>
                            </Switch>
                        </>
                    ))}
                </Router>

            </div>

        </div>
    )
}
export default Properties
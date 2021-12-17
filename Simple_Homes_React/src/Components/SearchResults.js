import React from "react";
import {Link} from "react-router-dom";
import PropertyContainer from "./PropertyContainer";

const SearchResults = (props) => {
    if(!props.array){return(<div></div>)}

    return (
        <div>
            {props.array.map(p => (
                <div>
                    <PropertyContainer key={p.id} p={p}/>
                </div>
            ))}
        </div>
    )
}

export default SearchResults
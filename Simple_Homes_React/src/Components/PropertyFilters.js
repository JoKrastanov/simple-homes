import React from "react";
import "../StyleSheets/PropertyFilters.css";

function PropertyFilters() {
    return (
        <div className={"PropertyFilters"}>
            <div className={"PropertyFilters-type"}>
                <div className={"PropertyFilters-type-Room"}>
                    <input type={"checkbox"} name={"Room"}/>
                    <label htmlFor={"Room"}>Room</label>
                </div>
                <div className={"PropertyFilters-type-Apartment"}>
                    <input type={"checkbox"} name={"Apartment"}/>
                    <label htmlFor={"Apartment"}>Apartment</label>
                </div>
                <div className={"PropertyFilters-type-Studio"}>
                    <input type={"checkbox"} name={"Studio"}/>
                    <label htmlFor={"Studio"}>Studio</label>
                </div>
                <div className={"PropertyFilters-type-House"}>
                    <input type={"checkbox"} name={"House"}/>
                    <label htmlFor={"House"}>House</label>
                </div>
            </div>
        </div>
    )
}

export default PropertyFilters;
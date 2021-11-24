import React, {useState, useRef} from "react";
import "../StyleSheets/PropertyFilters.css";
import MultiRangeSlider from "./MultiRangeSlider";


function PropertyFilters() {

    return (
        <div className={"PropertyFilters"}>
            <div className={"property-filter-types"}>
                <div id={"filters"} className={"PropertyFilters-price"}>
                    <button className={"filter-button"}>Price</button>
                    <div className={"PropertyFilters-price-menu"}>
                        <MultiRangeSlider
                            min={0}
                            max={6000}
                            onChange={({ min, max }) => console.log(`min = ${min}, max = ${max}`)}
                        />
                    </div>
                </div>
                <div id={"filters"} className={"PropertyFilters-type"}>
                    <button className={"filter-button"}>Type</button>
                </div>
                <div id={"filters"} className={"PropertyFilters-interior"}>
                    <button className={"filter-button"}>Interior</button>
                </div>
                <div id={"filters"} className={"PropertyFilters-size"}>
                    <button className={"filter-button"}>Size</button>
                </div>
                <div id={"filters"} className={"PropertyFilters-location"}>
                    <input id={"tbSearch"} placeholder="Search by city , address or postcode"/>
                    <button className={"filter-button"}>Search</button>
                </div>
            </div>
            <div className={"property-filter-options"}>

            </div>
        </div>
    )
}

export default PropertyFilters;
import React, {useState, useRef} from "react";
import "../StyleSheets/PropertyFilters.css";
import PriceFilter from "./PriceFilter";


function PropertyFilters() {

    const [priceFilter, togglePriceFilter] = useState(false);

    function togglePriceFilterFunction() {
        togglePriceFilter(!priceFilter)
        if (priceFilter) {document.getElementById("price-visible").style.visibility = "visible" ;}
        else {document.getElementById("price-visible").style.visibility= "hidden" ;}
    }

    return (
        <div className={"PropertyFilters"}>
            <div className={"property-filter-types"}>
                <div id={"filters"} className={"PropertyFilters-price"}>
                    <button className={"filter-button"} >Price</button>
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
            <div className={"property-filter-options"} id={"price-filter"}>
                <div className={"price-filter"}>
                    <PriceFilter/>
                </div>
            </div>
        </div>
    )
}

export default PropertyFilters;
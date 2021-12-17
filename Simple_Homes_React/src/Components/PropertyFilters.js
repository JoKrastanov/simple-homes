import React, {useState, useRef} from "react";
import "../StyleSheets/PropertyFilters.css";


function PropertyFilters() {

    const [price, setPrice] = useState();
    const [type, setType] = useState();
    const [interior, setInterior] = useState();
    const [size, setSize] = useState();


    const updatePrice = (newPrice) => {
        setPrice(newPrice);
        console.log(price);
    }



    return (
        <div className={"PropertyFilters"}>
            <div className={"property-filter-types"}>
                <div id={"filters"} className={"PropertyFilters-price"}>
                    <button className={"filter-button"}>Price</button>
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
                <div id={"filters"} className={"PropertyFilters-size"}>
                    <button className={"filter-button"}>City</button>
                </div>
            </div>
{/*            <div className={"properties-filter-options"}>

            </div>*/}
        </div>
    )
}

export default PropertyFilters;
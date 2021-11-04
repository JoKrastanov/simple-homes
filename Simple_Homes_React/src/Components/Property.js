import React, {useEffect, useState} from "react";
import axios from "axios";

import "../StyleSheets/PropertyPopUp.css";

function Property(property) {

    console.log(property);

    return(
        <div className={"Property"}>
            <h1>test</h1>
            <p>{property.id}</p>
            <p>{property.forSale ? "For Sale" : "For Rent"}: {property.type} {property.address} in {property.city}</p>
        </div>
    )
}

export default Property
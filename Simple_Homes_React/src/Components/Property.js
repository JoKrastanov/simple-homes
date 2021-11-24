import React, {useEffect, useState} from "react";
import axios from "axios";

import "../StyleSheets/PropertyPopUp.css";

const Property = (property) => {
    return(
        <div className={"Property"}>
            <p>{property.id}</p>
            <p>{property.forSale ? "For Sale" : "For Rent"}: {property.type} {property.address} in {property.city}</p>
        </div>
    )
}

export default Property
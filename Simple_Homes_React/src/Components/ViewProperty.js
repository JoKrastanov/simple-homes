import React, {useEffect, useState} from "react";
import axios from "axios";
import Cookies from "universal-cookie/lib";
import "../StyleSheets/ViewProperty.css"
import placeholderImg from "../Images/5089528.jpg"
import sizeImg from "../Images/size.png"
import interiorImg from "../Images/interior.png"
import roomsImg from "../Images/rooms.png"
import ScheduleViewing from "./ScheduleViewing";

const ViewProperty = ({match}) => {
    const baseURL = "http://localhost:8080/properties/";
    const cookie = new Cookies();
    const propertyId =  match.params.id;
    const user = cookie.get("user");

    useEffect(() => {
         axios
             .get(baseURL+propertyId)
             .then((response) => {
            setProperty(response.data)
        });
    }, []);

    const [property, setProperty] = useState(null);

if(property != null)
    return(
      <div className={"property"}>
          <img src={placeholderImg}/>
          <div id={"main-info"}>
              <h2>For rent: {property.type} {property.address} in {property.city}</h2>
              <p>{property.postalCode}</p>
              <h3>Price : {property.price}€ /month</h3>
          </div>
          <div className={"lower"}>
              <div id={"description"}>
                  <div id={"characteristics"}>
                      <p><img src={roomsImg}/>{property.rooms}</p>
                      <p><img src={interiorImg}/>{property.interior}</p>
                      <p><img src={sizeImg}/>{property.size}m²</p>
                  </div>
                  <p>{property.description}</p>
              </div>
              <div id={"contact"}>
                  <ScheduleViewing publisher={property.publisherId} property={property.id} user={user}/>
              </div>
          </div>
      </div>
    );
else {return (<></>)}
}

export default ViewProperty;
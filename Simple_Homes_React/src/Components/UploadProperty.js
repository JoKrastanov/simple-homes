import "../StyleSheets/UploadProperty.css"

import React, {useEffect, useState} from "react";
import axios from "axios";
import moment, {now} from "moment";
import {useHistory} from "react-router-dom";


function UploadProperty(props) {
    let baseURL = "http://localhost:8080/properties/";
    let token = props.token;
    let user = props.user
    let history = useHistory();
    let interiors = ["Furnished", "Upholstered", "Unfurnished"];

    const [type, setType] = useState();
    const [price, setPrice] = useState();
    const [description, setDescription] = useState();
    const [address, setAddress] = useState();
    const [code, setCode] = useState();
    const [city, setCity] = useState();
    const [size, setSize] = useState();
    const [date, setDate] = useState();
    const [rooms, setRooms] = useState();
    const [interior, setInterior] = useState();
    const [today, setToday] = useState();
    const [submitted, setSubmitted] = useState(false);

    const handleType = (e) => {
        setType(e.target.value);
        setSubmitted(false);
    }
    const handlePrice = (e) => {
        setPrice(e.target.value);
        setSubmitted(false);
    }
    const handleDescription = (e) => {
        setDescription(e.target.value);
        setSubmitted(false);
    }
    const handleAddress = (e) => {
        setAddress(e.target.value);
        setSubmitted(false);
    }
    const handleCode = (e) => {
        setCode(e.target.value);
        setSubmitted(false);
    }
    const handleCity = (e) => {
        setCity(e.target.value);
        setSubmitted(false);
    }
    const handleSize = (e) => {
        setSize(e.target.value);
        setSubmitted(false);
    }
    const handleDate = (e) => {
        setDate(e.target.value);
        setSubmitted(false);
    }
    const handleRooms = (e) => {
        setRooms(e.target.value);
        setSubmitted(false);
    }
    const handleInterior = (e) => {
        setInterior(e.target.value);
        setSubmitted(false);
    }


    useEffect(() => {
        const dateNow =  moment(now()).format("yyyy-MM-DD hh:mm:ss");
        setToday(dateNow)
    }, []);

    const handleSubmit = (e) => {
        e.preventDefault()
        const dateUpload = moment(date).format("yyyy-MM-DD hh:mm:ss");
        axios
            .post(baseURL, {
                    type: type,
                    price: price,
                    taken: false,
                    description: description,
                    forSale: false,
                    publisherId: user,
                    address: address,
                    postalCode: code,
                    city: city,
                    size: size,
                    dateAvailable: today,
                    datePublished: dateUpload,
                    rooms: rooms,
                    interior: interior

            }, {headers: {
                'Authorization' : token
        }})
            .then((response) => {
                if(response.status === 201) {
                    history.push("/Profile")
                }
            });
    }
    if(props.token === "") {return (<div>Please log in first</div>)}
    return (
        <div className={"upload"}>
            <form onSubmit={handleSubmit}>
                <div className={"main-info"}>
                    <div className={"location-details"}>
                        <div className={"location"}>
                            <label htmlFor="address"><b>Address</b></label>
                            <input value={address} onChange={handleAddress} type="text" placeholder="Enter Address" name="address" id="address" required/>
                            <label htmlFor="code"><b>Post Code</b></label>
                            <input value={code} onChange={handleCode} type="text" placeholder="Enter Post Code" name="code" id="code" required/>
                            <label htmlFor="city"><b>City</b></label>
                            <input value={city} onChange={handleCity} type="text" placeholder="Enter City" name="city" id="city" required/>
                        </div>
                        <div className={"details"}>
                            <label htmlFor="size"><b>Size in m²</b></label>
                            <input value={size} onChange={handleSize} type="text" pattern="[0-9]*" placeholder="Size" name="size" id="size" required/>
                            <label htmlFor="price"><b>Price in €</b></label>
                            <input value={price} onChange={handlePrice} type="text" pattern="[0-9]*" placeholder="Price" name="price" id="price" required/>
                            <label htmlFor="rooms"><b>Rooms</b></label>
                            <input value={rooms} onChange={handleRooms} type="text" pattern="[0-9]*" placeholder="Rooms" name="rooms" id="rooms" required/>
                        </div>
                    </div>

                    <div className={"description"}>
                    <textarea value={description} onChange={handleDescription} id="description" name="description" rows="20" cols="80" placeholder={"Provide a description"}>

                    </textarea>
                    </div>
                </div>
                <div className={"additional"}>
                    <div className={"additional-type"}>
                        <div className={"additional-type-label"}>
                            <label htmlFor="type"><b>Property Type</b></label>
                        </div>
                            <input type={"radio"} value="Room" onChange={handleType} required={true} name={"type"} id={"type1"}/>
                        <label htmlFor="type1"><b>Room</b></label>
                            <input type={"radio"} value="Studio" onChange={handleType} required={true} name={"type"} id={"type2"}/>
                        <label htmlFor="type2"><b>Studio</b></label>
                        <input type={"radio"} value="Apartment" onChange={handleType} required={true} name={"type"} id={"type3"}/>
                        <label htmlFor="type3"><b>Apartment</b></label>
                    </div>
                    <div className={"additional-interior"}>
                        <div className={"additional-interior-label"}>
                            <label htmlFor="interior"><b>Property Interior   </b></label>
                        </div>
                        <input type={"radio"} value={interiors[0]} id={"interior1"} onChange={handleInterior} required={true} name={"interior"}/>
                        <label htmlFor="interior1"><b>Furnished</b></label>
                        <input type={"radio"} value={interiors[1]} id={"interior2"} onChange={handleInterior} required={true} name={"interior"}/>
                        <label htmlFor="interior2"><b>Upholstered</b></label>
                        <input type={"radio"} value={interiors[2]} id={"interior3"} onChange={handleInterior} required={true} name={"interior"}/>
                        <label htmlFor="interior3"><b>Unfurnished</b></label>
                    </div>
                </div>
                <div>
                    <label htmlFor="available"><b>Date available</b></label>
                    <input value={date} onChange={handleDate} type="datetime-local" name="available" id="available" required/>
                </div>
                <button id={"submit-button"} type={"submit"}>Upload Property</button>
            </form>
        </div>
    );
}

export default UploadProperty;
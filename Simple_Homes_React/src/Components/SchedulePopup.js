import React, {useEffect, useState} from "react";
import Calendar from "react-calendar";
import "../StyleSheets/SchedulePopup.css";
import 'react-calendar/dist/Calendar.css';
import axios from "axios";
import Cookies from "universal-cookie/lib";
import moment from "moment";

function SchedulePopup(props) {

    const baseURL = "http://localhost:8080/properties/viewing"
    const getDates = "http://localhost:8080/properties/viewing/property/" + props.property;
    const cookie = new Cookies()
    const [date, setDate] = useState(new Date());
    let dates = [];

    useEffect(() => {
        axios
            .get(getDates, {
                headers: {
                    'Authorization': localStorage.getItem("authToken")
                }
            })
            .then((response) => {
                console.log(response.data)
                const viewings = response.data;
                console.log(viewings)
                viewings.map(viewing => {
                    dates.push(viewing.viewingDate);
                    console.log(dates);
                })
            }
        )
    }, [])

    const scheduleViewing = () => {
        axios.post(baseURL, {
            propertyId: props.property,
            accountId: cookie.get("user"),
            viewingDate: date
        }).then(props.onChange)
     }

    return (
        <div className={"schedule-popup"}>
            <div className={"schedule-popup-content"}>
                <Calendar onChange={setDate}
                          value={date}
                          minDate={moment().toDate()}
                />
                <div id={"schedule-buttons"}>
                    <button id={"schedule"} onClick={scheduleViewing}>Schedule</button>
                    <button id={"close"} onClick={props.onChange}>Cancel</button>
                </div>

            </div>
        </div>
        )
}

export default SchedulePopup
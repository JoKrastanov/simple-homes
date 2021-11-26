import React, {useState} from "react";

import "../StyleSheets/PriceFilter.css"

import {Flex, RangeSlider} from "@adobe/react-spectrum";

const PriceFilter = () => {
        const [value, setValue] = useState({start: 1, end: 6000});

        return (
            <div className={"PriceFilter"}>
                <RangeSlider
                    formatOptions={{style: 'currency', currency: 'EUR'}}
                    maxValue= {6000}
                    label="Price Range: "
                    value={value}
                    onChange={setValue}/>
            </div>
        );
}

export default PriceFilter
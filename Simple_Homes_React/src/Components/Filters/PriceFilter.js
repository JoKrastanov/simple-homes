import React, {useEffect, useState} from "react";

import "../../StyleSheets/PriceFilter.css"

const PriceFilter = (props) => {

    useEffect(() => {

    }, [])

        return (
            <div className={"PriceFilter"}>
                <select onChange={(event => props.onChange(event.target.value))}>
                    <option value={"1"}>&lt;400€</option>
                    <option value={"2"}>&lt;500€</option>
                    <option value={"3"}>&lt;800€</option>
                    <option value={"4"}>&lt;1000€</option>
                    <option value={"5"}>&lt;1500€</option>
                    <option value={"6"}>&lt;3000€</option>
                </select>
            </div>
        );
}

export default PriceFilter
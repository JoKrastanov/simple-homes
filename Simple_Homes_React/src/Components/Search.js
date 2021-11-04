import React from "react";

import "../StyleSheets/Search.css";

const SearchBar = () => (
    <form action="/" method="get">
        <label htmlFor="header-search">
        </label>
        <input
            type="text"
            id="header-search"
            placeholder="Search a city, street or post code"
            name="s"
        />
        <button id={"search-button"} type="submit">Search</button>
    </form>
);

export default SearchBar;
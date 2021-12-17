import React, {useState} from "react";

import "../StyleSheets/Search.css";
import axios from "axios";
import SearchResults from "./SearchResults";

const SearchBar = () => {

        const baseURL = "http://localhost:8080/properties/search/";
        const [location, setLocation] = useState("");
        const [post, setPost] = useState(null);

        const searchProperty = (e) => {
                if(e.target.value !== "") {
                        let finalUrl = baseURL + e.target.value;
                        axios
                            .get(finalUrl)
                            .then((response) => {
                                    if (response.status === 200) {
                                            setPost(response.data);
                                    }
                            })
                }
                else {setPost("")}
        }

        return (
            <div>
                    <label htmlFor="header-search">
                    </label>
                    <input
                        type="text"
                        id="header-search"
                        placeholder="Search a city, street or post code"
                        name="s"
                        onChange={searchProperty}
                    />
                    <SearchResults  array={post}/>
            </div>
        )
}

export default SearchBar;
import './StyleSheets/App.css';
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import NavBar from "./Components/NavBar";
import Overview from "./Components/Overview";
import {Link} from 'react-router-dom'
import {useSelector, useDispatch} from 'react-redux'
import { useCookies } from 'react-cookie'
import { useHistory } from 'react-router-dom'
import * as path from "path";

function App() {
        return (
            <div className="App">
                <NavBar/>
            </div>
        );
}
export default App;


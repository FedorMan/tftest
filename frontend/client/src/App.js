import React, {Component} from 'react';
import './App.css';
import City from './City'
import {Router, Route, Link} from 'react-router-dom'
import createBrowserHistory from 'history/createBrowserHistory'
import Weather from "./Weather/Weather";

const history = createBrowserHistory();

class App extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <Router history = {history}>
                <div>
                    <Route exact path = '/' component={City}/>
                    <Route exact path = '/weather/:cityId' component={Weather}/>
                </div>
            </Router>
        );
    }
}

export default App;

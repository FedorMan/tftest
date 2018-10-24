import React, {Component} from 'react';
import './App.css';
import City from './City'

class App extends Component {
    constructor(props) {
        super(props)
        this.state = {cities: []}
    }
    render() {
        return (
            <City/>
        );
    }
}

export default App;

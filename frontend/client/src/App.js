import React, {Component} from 'react';
import {Get} from 'react-axios'
import './App.css';

class App extends Component {
    constructor(props) {
        super(props)
        this.state = {cities: []}
    }

    render() {
        return (
            <div className="App">
                <Get url="http://localhost:8080/weather/cities">
                    {(error, response, isLoading, onReload) => {
                        if (error) {
                            return (<div>Something bad happened: {error.message}
                                <button onClick={() => onReload({params: {reload: true}})}>Retry</button>
                            </div>)
                        }
                        else if (isLoading) {
                            return (<div>Loading...</div>)
                        }
                        else if (response !== null) {
                            return (<div>
                                    {
                                        response.data.map((city: any) =>
                                            (
                                                <div>{city.name} {city.currentWeather.temperature}</div>
                                            )
                                        )}
                                </div>
                        )
                    }
                        return (<div>Default message before request is made.</div>)
                    }}
                </Get>
            </div>
        );
    }
}

export default App;

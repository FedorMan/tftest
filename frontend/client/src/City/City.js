import "./City.css";
import React, {Component} from 'react';
import {Get} from "react-axios";

class City extends Component {
    constructor(props) {
        super(props)
        this.state = {cities: []}
    }

    render() {
        return (
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
                                            <div className="container" key={city.id}>
                                                <div className="row">
                                                    <div className="col">
                                                        <div className="weather-card one" style={{
                                                            backgroundImage: 'url(' + city.pathToImg + ')',
                                                            backgroundRepeat: 'no-repeat',
                                                            backgroundPosition: 'center',
                                                            backgroundSize: 'cover'
                                                        }}>
                                                            <div className="top">
                                                                <div className="wrapper">
                                                                    <h1 className="location">{city.name}</h1>
                                                                    <p className="temp">
                                                                        <span
                                                                            className="temp-value">{city.currentWeather.temperature}</span>
                                                                        <span className="deg">0</span>
                                                                        <a><span className="temp-type">C</span></a>
                                                                    </p>
                                                                    <p className="temp">
                                                                        <span
                                                                            className="temp-value">{city.currentWeather.windSpeed}</span>
                                                                        <a><span className="temp-type">м/с</span></a>
                                                                    </p>
                                                                </div>
                                                            </div>
                                                            <div className="bottom">
                                                                <div className="wrapper">
                                                                    <ul className="forecast">
                                                                        <li>
                                                                            <span className="date">Tomorrow</span>
                                                                            <span className="lnr lnr-cloud condition">
									                                                <span className="temp">21
                                                                                        <span className="deg">0</span>
                                                                                        <span className="temp-type">C</span>
                                                                                    </span>
                                                                            </span>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        )
                                    )}
                            </div>
                        )
                    }
                    return (<div>Default message before request is made.</div>)
                }}
            </Get>
        );
    }

}

export default City;

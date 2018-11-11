import "./Weather.css";
import React, {Component} from "react";
import {Get} from "react-axios";

class Weather extends Component {
    constructor(props) {
        super(props)
        this.state = {cities: []}
    }

    getPath(){
        return 'http://localhost:8080/weather/forecast/:cityId'.replace(":cityId",this.props.match.params.cityId)
    }

    render() {
        return (
            <Get url={this.getPath()} >
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
                        return (
                            <div className="container">
                                <div className="row">
                                    <div className="seven-col-grid">Monday</div>
                                    <div className="seven-col-grid">Tuesday</div>
                                    <div className="seven-col-grid">Wendsday</div>
                                    <div className="seven-col-grid">Thursday</div>
                                    <div className="seven-col-grid">Friday</div>
                                    <div className="seven-col-grid">Saturday</div>
                                    <div className="seven-col-grid">Sunday</div>
                                </div>
                                <div className="row">
                                    {
                                        response.data.map((weather: any) =>
                                            (
                                                <div className="seven-col-grid blueGround d-flex align-items-stretch card" key={weather.id}>
                                                    <div className="card-body">
                                                        <h5 className="card-title">{weather.futureDate[2]}/{weather.futureDate[1]}</h5>
                                                        <div className="weatherIcon">
                                                            <div className={weather.sky}>
                                                                <div className="inner"></div>
                                                            </div>
                                                        </div>
                                                        <h6 className="card-subtitle mb-2">{weather.minTemperature}°/{weather.maxTemperature}°</h6>
                                                    </div>
                                                </div>
                                            )
                                        )
                                    }
                                </div>
                            </div>
                        )
                    }
                    return (<div>Default message before request is made.</div>)
                }}
            </Get>
        );
    }
}

export default Weather;
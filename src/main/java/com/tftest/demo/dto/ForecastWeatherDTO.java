package com.tftest.demo.dto;

import com.tftest.demo.entity.ForecastWeather;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ForecastWeatherDTO {
    private int id;
    private double maxTemperature;
    private double minTemperature;
    private LocalDate futureDate;
    private String sky;

    public ForecastWeatherDTO(ForecastWeather forecastWeather){
        id = forecastWeather.getId();
        maxTemperature = Math.round(forecastWeather.getMaxTemperature());
        minTemperature = Math.round(forecastWeather.getMinTemperature());
        futureDate = forecastWeather.getFutureDate();
        switch (forecastWeather.getSky()){
            case "Rain And Snow": sky = "sleet";
            break;
            case "Cloudy": sky = "cloudy";
            break;
            case "Mostly Cloudy": sky = "mostlycloudy";
                break;
            case "Partly Cloudy": sky = "mostlysunny";
                break;
            case "Rain": sky = "rain";
                break;
//            case "Breezy": sky = "sunny";
//                break;
            case "Sunny": sky = "sunny";
                break;
        }
//        sky = forecastWeather.getSky();
    }
}

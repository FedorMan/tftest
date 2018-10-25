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

    public ForecastWeatherDTO(ForecastWeather forecastWeather){
        id = forecastWeather.getId();
        maxTemperature = forecastWeather.getMaxTemperature();
        minTemperature = forecastWeather.getMinTemperature();
        futureDate = forecastWeather.getFutureDate();
    }
}

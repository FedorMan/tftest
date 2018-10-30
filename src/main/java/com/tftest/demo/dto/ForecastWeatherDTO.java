package com.tftest.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.tftest.demo.entity.ForecastWeather;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * DTO for return forecast weather on controller
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForecastWeatherDTO {
    private int id;
    private double maxTemperature;
    private double minTemperature;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
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
            case "Scattered Showers": sky = "flurries";
                break;
            case "Sunny": sky = "sunny";
                break;
            case "Mostly Sunny": sky = "mostlysunny";
                break;
        }
    }
}

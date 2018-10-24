package com.tftest.demo.dto;

import com.tftest.demo.entity.CurrentWeather;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CurrentWeatherDTO {
    private double temperature;
    private double windSpeed;
    private LocalDateTime updateTime;

    public CurrentWeatherDTO(CurrentWeather currentWeather){
        temperature = Math.round(currentWeather.getTemperature());
        windSpeed = Math.round(currentWeather.getWindSpeed());
        updateTime = currentWeather.getUpdateTime();
    }
}

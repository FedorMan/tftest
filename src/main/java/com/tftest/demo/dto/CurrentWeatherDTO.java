package com.tftest.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CurrentWeatherDTO {
    private double temperature;
    private double windSpeed;
    private LocalDateTime updateTime;
}

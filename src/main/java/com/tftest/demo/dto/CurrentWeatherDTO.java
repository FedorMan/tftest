package com.tftest.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CurrentWeatherDTO {private int id;
    private double temperature;
    private double windSpeed;
    private LocalDate updateTime;
}

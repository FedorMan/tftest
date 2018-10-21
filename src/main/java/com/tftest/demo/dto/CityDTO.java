package com.tftest.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityDTO {
    private Integer id;
    private String name;
    private CurrentWeatherDTO currentWeather;
}

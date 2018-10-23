package com.tftest.demo.dto;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
public class CityDTO {
    private Integer id;
    private String name;
    private CurrentWeatherDTO currentWeather;
    private List<ForecastWeatherDTO> forecastWeathers;

    public CityDTO(City city){
        id = city.getId();
        name = city.getName();
        CurrentWeather currentWeather = city.getCurrentWeathers().get(city.getCurrentWeathers().size() - 1);
        this.currentWeather = new CurrentWeatherDTO(currentWeather);
        forecastWeathers = new LinkedList<>();
        city.getForecastWeathers().forEach(forecastWeather -> forecastWeathers.add(new ForecastWeatherDTO(forecastWeather)));
    }
}

package com.tftest.demo.dto;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DTO for return city on controller and last get time from source
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CityDTO {

    private Integer id;
    private String name;
    private CurrentWeatherDTO currentWeather;
    private String pathToImg;

    public CityDTO(City city){
        id = city.getId();
        name = city.getName();
        pathToImg = city.getPathToImg();
        CurrentWeather currentWeather = city.getCurrentWeathers().get(city.getCurrentWeathers().size() - 1);
        this.currentWeather = new CurrentWeatherDTO(currentWeather);
    }
}

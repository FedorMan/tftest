package com.tftest.demo.dto;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityDTO {
    private Integer id;
    private String name;
    private CurrentWeatherDTO currentWeather;

    public CityDTO(City city){
        id = city.getId();
        name = city.getName();
        CurrentWeather currentWeather = city.getCurrentWeathers().stream()
                .max((o1, o2) -> o1.getUpdateTime().compareTo(o2.getUpdateTime())).get();
        this.currentWeather = new CurrentWeatherDTO(currentWeather);
    }
}

package com.tftest.demo.dto;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;

import java.util.Objects;

/**
 * DTO for return city on controller and last get time from source
 */
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

    public CityDTO(Integer id, String name, CurrentWeatherDTO currentWeather, String pathToImg) {
        this.id = id;
        this.name = name;
        this.currentWeather = currentWeather;
        this.pathToImg = pathToImg;
    }

    public CityDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrentWeatherDTO getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeatherDTO currentWeather) {
        this.currentWeather = currentWeather;
    }

    public String getPathToImg() {
        return pathToImg;
    }

    public void setPathToImg(String pathToImg) {
        this.pathToImg = pathToImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDTO cityDTO = (CityDTO) o;
        return Objects.equals(id, cityDTO.id) &&
                Objects.equals(name, cityDTO.name) &&
                Objects.equals(currentWeather, cityDTO.currentWeather) &&
                Objects.equals(pathToImg, cityDTO.pathToImg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, currentWeather, pathToImg);
    }
}

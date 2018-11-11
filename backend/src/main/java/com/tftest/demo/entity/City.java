package com.tftest.demo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Entity city in application
 */
@Entity
public class City {
    @Id
    private int id;
    private String name;
    /**
     * path to img of city
     */
    private String pathToImg;
    /**
     * list current weathers by city
     * @see {@link CurrentWeather}
     */
    @OrderBy("updateTime")
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<CurrentWeather> currentWeathers;
    /**
     * list forecast weathers by city
     * @see {@link ForecastWeather}
     */
    @OrderBy("futureDate")
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<ForecastWeather> forecastWeathers;
    /**
     * list sources weather
     * @see {@link CityOnSourceWeather}
     */
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private List<CityOnSourceWeather> weatherSources;

    public City(int id, String name, String pathToImg, List<CurrentWeather> currentWeathers, List<ForecastWeather> forecastWeathers, List<CityOnSourceWeather> weatherSources) {
        this.id = id;
        this.name = name;
        this.pathToImg = pathToImg;
        this.currentWeathers = currentWeathers;
        this.forecastWeathers = forecastWeathers;
        this.weatherSources = weatherSources;
    }

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPathToImg() {
        return pathToImg;
    }

    public void setPathToImg(String pathToImg) {
        this.pathToImg = pathToImg;
    }

    public List<CurrentWeather> getCurrentWeathers() {
        return currentWeathers;
    }

    public void setCurrentWeathers(List<CurrentWeather> currentWeathers) {
        this.currentWeathers = currentWeathers;
    }

    public List<ForecastWeather> getForecastWeathers() {
        return forecastWeathers;
    }

    public void setForecastWeathers(List<ForecastWeather> forecastWeathers) {
        this.forecastWeathers = forecastWeathers;
    }

    public List<CityOnSourceWeather> getWeatherSources() {
        return weatherSources;
    }

    public void setWeatherSources(List<CityOnSourceWeather> weatherSources) {
        this.weatherSources = weatherSources;
    }
}

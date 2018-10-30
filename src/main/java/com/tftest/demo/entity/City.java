package com.tftest.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Entity city in application
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}

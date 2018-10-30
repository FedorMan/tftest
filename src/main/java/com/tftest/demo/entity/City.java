package com.tftest.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    private int id;
    private String name;
    private String pathToImg;
    @OrderBy("updateTime")
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<CurrentWeather> currentWeathers;
    @OrderBy("futureDate")
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<ForecastWeather> forecastWeathers;
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private List<CityOnSourceWeather> weatherSources;
}

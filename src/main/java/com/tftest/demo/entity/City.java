package com.tftest.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class City {
    @Id
    private int id;
    private String name;
    @OrderBy("updateTime")
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<CurrentWeather> currentWeathers;
    @OrderBy("futureDate")
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<ForecastWeather> forecastWeathers;
    private String pathToImg;
}

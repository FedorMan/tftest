package com.tftest.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
public class ForecastWeather extends Weather{
    private double maxTemperature;
    private double minTemperature;
    private LocalDate futureDate;
}

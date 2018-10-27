package com.tftest.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForecastWeather extends Weather{
    private double maxTemperature;
    private double minTemperature;
    private LocalDate futureDate;
}

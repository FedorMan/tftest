package com.tftest.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Forecast weather entity
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForecastWeather extends Weather{
    /**
     * temperture in C
     */
    private double maxTemperature;
    /**
     * temperture in C
     */
    private double minTemperature;
    /**
     * date in City
     */
    private LocalDate futureDate;
    /**
     * type sky for img
     */
    private String sky;
}

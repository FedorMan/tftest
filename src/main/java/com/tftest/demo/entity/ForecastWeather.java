package com.tftest.demo.entity;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Forecast weather entity
 */
@Entity
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

    public ForecastWeather(double maxTemperature, double minTemperature, LocalDate futureDate, String sky) {
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.futureDate = futureDate;
        this.sky = sky;
    }

    public ForecastWeather() {
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public LocalDate getFutureDate() {
        return futureDate;
    }

    public void setFutureDate(LocalDate futureDate) {
        this.futureDate = futureDate;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }
}

package com.tftest.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Current weather entity
 */
@Entity
public class CurrentWeather extends Weather{
    /**
     * temperture in C
     */
    private double temperature;
    /**
     * speed in ms
     */
    private double windSpeed;
    /**
     * update time in City
     */
    private LocalDateTime updateTime;

    public CurrentWeather(double temperature, double windSpeed, LocalDateTime updateTime) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.updateTime = updateTime;
    }

    public CurrentWeather() {
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}

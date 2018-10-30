package com.tftest.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.tftest.demo.entity.CurrentWeather;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DTO for return current weather on controller
 */
public class CurrentWeatherDTO {

    private double temperature;
    private double windSpeed;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updateTime;

    public CurrentWeatherDTO(double temperature, double windSpeed, LocalDateTime updateTime) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.updateTime = updateTime;
    }

    public CurrentWeatherDTO() {
    }

    public CurrentWeatherDTO(CurrentWeather currentWeather){
        temperature = Math.round(currentWeather.getTemperature());
        windSpeed = Math.round(currentWeather.getWindSpeed());
        updateTime = currentWeather.getUpdateTime();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentWeatherDTO that = (CurrentWeatherDTO) o;
        return Double.compare(that.temperature, temperature) == 0 &&
                Double.compare(that.windSpeed, windSpeed) == 0 &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, windSpeed, updateTime);
    }
}

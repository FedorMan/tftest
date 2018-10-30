package com.tftest.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.tftest.demo.entity.ForecastWeather;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for return forecast weather on controller
 */
public class ForecastWeatherDTO {
    private int id;
    private double maxTemperature;
    private double minTemperature;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate futureDate;
    private String sky;

    public ForecastWeatherDTO(int id, double maxTemperature, double minTemperature, LocalDate futureDate, String sky) {
        this.id = id;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.futureDate = futureDate;
        this.sky = sky;
    }

    public ForecastWeatherDTO() {
    }

    public ForecastWeatherDTO(ForecastWeather forecastWeather){
        id = forecastWeather.getId();
        maxTemperature = Math.round(forecastWeather.getMaxTemperature());
        minTemperature = Math.round(forecastWeather.getMinTemperature());
        futureDate = forecastWeather.getFutureDate();
        switch (forecastWeather.getSky()){
            case "Rain And Snow": sky = "sleet";
            break;
            case "Cloudy": sky = "cloudy";
            break;
            case "Mostly Cloudy": sky = "mostlycloudy";
                break;
            case "Partly Cloudy": sky = "mostlysunny";
                break;
            case "Rain": sky = "rain";
                break;
            case "Scattered Showers": sky = "flurries";
                break;
            case "Sunny": sky = "sunny";
                break;
            case "Mostly Sunny": sky = "mostlysunny";
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForecastWeatherDTO that = (ForecastWeatherDTO) o;
        return id == that.id &&
                Double.compare(that.maxTemperature, maxTemperature) == 0 &&
                Double.compare(that.minTemperature, minTemperature) == 0 &&
                Objects.equals(futureDate, that.futureDate) &&
                Objects.equals(sky, that.sky);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maxTemperature, minTemperature, futureDate, sky);
    }
}

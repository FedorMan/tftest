package com.tftest.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Current weather entity
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}

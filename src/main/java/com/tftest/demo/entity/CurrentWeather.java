package com.tftest.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class CurrentWeather extends Weather{
    private double temperature;
    private double windSpeed;
    private LocalDateTime updateTime;
}

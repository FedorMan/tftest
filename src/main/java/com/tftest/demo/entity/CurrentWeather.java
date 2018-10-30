package com.tftest.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentWeather extends Weather{
    private double temperature;
    private double windSpeed;
    private LocalDateTime updateTime;
}

package com.tftest.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class CurrentWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double temperature;
    private double windSpeed;
    private LocalDateTime updateTime;
    @ManyToOne
    private City city;
}

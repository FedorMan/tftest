package com.tftest.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class CurrentWeather {
    @Id
    private int id;
    private double temperature;
    private double windSpeed;
    private LocalDate updateTime;
    @ManyToOne
    private City city;
}

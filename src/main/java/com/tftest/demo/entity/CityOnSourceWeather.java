package com.tftest.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class CityOnSourceWeather {
    @Id
    private int id;
    @ManyToOne
    private City city;
    private String source;
    private String cityIdOnSource;
}

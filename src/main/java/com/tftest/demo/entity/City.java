package com.tftest.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class City {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "city")
    private List<CurrentWeather> currentWeathers;
}

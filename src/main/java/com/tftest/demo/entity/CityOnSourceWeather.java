package com.tftest.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * entity for connect city and weather source
 */
@Data
@Entity
public class CityOnSourceWeather {
    @Id
    private int id;
    /**
     * city in application
     * @see {@link City}
     */
    @ManyToOne
    private City city;
    /**
     * name source for example yahoo
     */
    private String source;
    /**
     * id city in source string len == 15
     */
    private String cityIdOnSource;
}

package com.tftest.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * entity for connect city and weather source
 */
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCityIdOnSource() {
        return cityIdOnSource;
    }

    public void setCityIdOnSource(String cityIdOnSource) {
        this.cityIdOnSource = cityIdOnSource;
    }
}

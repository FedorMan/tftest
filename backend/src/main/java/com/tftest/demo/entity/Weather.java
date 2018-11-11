package com.tftest.demo.entity;

import javax.persistence.*;

/**
 * Weather superclass
 */
@MappedSuperclass
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    /**
     * city in application
     */
    @ManyToOne
    protected City city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

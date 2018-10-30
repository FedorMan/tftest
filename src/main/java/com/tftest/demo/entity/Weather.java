package com.tftest.demo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Weather superclass
 */
@MappedSuperclass
@Data
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * city in application
     */
    @ManyToOne
    private City city;
}

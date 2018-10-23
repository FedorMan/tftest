package com.tftest.demo.entity;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private City city;
}

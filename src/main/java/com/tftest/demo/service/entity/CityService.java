package com.tftest.demo.service.entity;

import com.tftest.demo.entity.City;
import com.tftest.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for work with entity City
 */
@Service
public class CityService {

    /**
     * Repository for city
     * @see
     * {@link CityRepository}
     */
    @Autowired
    CityRepository cityRepository;

    /**
     *
     * @return List sities from database
     */
    public List<City> getCities() {
        return cityRepository.findAll();
    }
}

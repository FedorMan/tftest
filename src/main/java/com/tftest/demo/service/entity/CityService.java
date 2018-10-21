package com.tftest.demo.service.entity;

import com.tftest.demo.entity.City;
import com.tftest.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public List<City> getCities(){
        return cityRepository.findAll();
    }

}

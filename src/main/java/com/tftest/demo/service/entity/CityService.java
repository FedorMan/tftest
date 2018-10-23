package com.tftest.demo.service.entity;

import com.tftest.demo.dto.CityDTO;
import com.tftest.demo.entity.City;
import com.tftest.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public List<City> loadCities() {
        return cityRepository.findAll();
    }

    public List<CityDTO> getCities() {
        List<City> cities = cityRepository.findAll();
        List<CityDTO> cityDTOs = new ArrayList<>();
        cities.forEach(city -> {
            cityDTOs.add(new CityDTO(city));
        });
        return cityDTOs;
    }

}

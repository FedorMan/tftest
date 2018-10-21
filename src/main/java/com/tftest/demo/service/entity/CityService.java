package com.tftest.demo.service.entity;

import com.tftest.demo.dto.CityDTO;
import com.tftest.demo.dto.CurrentWeatherDTO;
import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
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
            CurrentWeather currentWeather = city.getCurrentWeathers().stream()
                    .max((o1, o2) -> o1.getUpdateTime().compareTo(o2.getUpdateTime())).get();
            CurrentWeatherDTO currentWeatherDTO
                    = new CurrentWeatherDTO(currentWeather.getTemperature(), currentWeather.getWindSpeed(), currentWeather.getUpdateTime());
            cityDTOs.add(new CityDTO(city.getId(), city.getName(), currentWeatherDTO));
        });
        return cityDTOs;
    }

}

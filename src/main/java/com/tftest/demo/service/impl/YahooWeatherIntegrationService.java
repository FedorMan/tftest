package com.tftest.demo.service.impl;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.service.CityService;
import com.tftest.demo.service.CurrentWeatherService;
import com.tftest.demo.service.WeatherIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class YahooWeatherIntegrationService implements WeatherIntegrationService {

    @Autowired
    private CityService cityService;
    @Autowired
    private CurrentWeatherService currentWeatherService;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void loadCurrentWeather() {
        List<City> cities = cityService.getCities();
        cities.forEach(city -> {
            currentWeatherService.save(loadWeather(city));
        });
    }

    private CurrentWeather loadWeather(City city){
        CurrentWeather currentWeather = null;

        

        return currentWeather;
    }
}

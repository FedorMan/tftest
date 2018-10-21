package com.tftest.demo.service.integration.impl;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.service.entity.CityService;
import com.tftest.demo.service.entity.CurrentWeatherService;
import com.tftest.demo.service.integration.WeatherIntegrationService;
import com.tftest.demo.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YahooWeatherIntegrationService implements WeatherIntegrationService {

    @Autowired
    private CityService cityService;
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private CurrentWeatherService currentWeatherService;

    @Override
    public void loadCurrentWeather() {
        List<City> cities = cityService.getCities();
        cities.forEach(city -> {
            CurrentWeather currentWeather = weatherService.loadCurrentWeather(city);
            if (!currentWeatherService.existByTime(currentWeather.getUpdateTime(), city)){
                currentWeatherService.save(currentWeather);
            }
        });
    }
}

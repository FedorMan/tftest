package com.tftest.demo.service.integration.impl;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.entity.ForecastWeather;
import com.tftest.demo.service.entity.CityService;
import com.tftest.demo.service.entity.WeatherService;
import com.tftest.demo.service.integration.WeatherIntegrationService;
import com.tftest.demo.service.external.weather.ExternalWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherIntegrationServiceImpl implements WeatherIntegrationService {

    @Autowired
    private CityService cityService;
    @Autowired
    private ExternalWeatherService externalWeatherService;
    @Autowired
    private WeatherService weatherService;

    @Override
    public void loadWeather() {
        List<City> cities = cityService.loadCities();
        cities.forEach(city -> {
            CurrentWeather currentWeather = externalWeatherService.loadCurrentWeather(city);
            if (!weatherService.existCurrentWeatherByTime(currentWeather.getUpdateTime(), city)){
                weatherService.saveCurrentWeather(currentWeather);
            }
            List<ForecastWeather> forecastWeathers = externalWeatherService.loadForecastWeather(city);
            forecastWeathers.forEach(forecastWeather -> {
                weatherService.saveForecastWeather(forecastWeather);
            });
        });
    }
}

package com.tftest.demo.service.external.weather;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.entity.ForecastWeather;

import java.util.List;

/**
 * service for get CurrentWeather and ForecastWeather from external resource
 * for example @see
 */
public interface ExternalWeatherService {
    CurrentWeather loadCurrentWeather(City city);
    List<ForecastWeather> loadForecastWeather(City city);
}

package com.tftest.demo.service.external.weather;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.entity.ForecastWeather;

import java.util.List;

public interface ExternalWeatherService {
    public CurrentWeather loadCurrentWeather(City city);
    public List<ForecastWeather> loadForecastWeather(City city);
}

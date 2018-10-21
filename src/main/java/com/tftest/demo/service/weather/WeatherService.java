package com.tftest.demo.service.weather;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;

public interface WeatherService {
    public CurrentWeather loadCurrentWeather(City city);
}

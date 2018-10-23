package com.tftest.demo.service.external.weather;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;

public interface ExternalWeatherService {
    public CurrentWeather loadCurrentWeather(City city);
}

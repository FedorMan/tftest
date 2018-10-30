package com.tftest.demo.service.external.weather;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.entity.ForecastWeather;

import java.util.List;

/**
 * Service for get CurrentWeather and ForecastWeather from external resource
 * for example @see {@link com.tftest.demo.service.external.weather.impl.YahooExternalWeatherService}
 * @author FedorMan
 */
public interface ExternalWeatherService {
    /**
     *
     * @param city
     * @return current weather in city
     */
    CurrentWeather loadCurrentWeather(City city);

    /**
     *
     * @param city
     * @return foorecast weather list
     */
    List<ForecastWeather> loadForecastWeather(City city);
}

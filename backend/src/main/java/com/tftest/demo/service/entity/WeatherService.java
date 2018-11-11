package com.tftest.demo.service.entity;

import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.entity.ForecastWeather;
import com.tftest.demo.repository.CurrentWeatherRepository;
import com.tftest.demo.repository.ForecastWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for work with entities CurrentWeather and ForecastWeather
 */
@Service
public class WeatherService {

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;
    @Autowired
    private ForecastWeatherRepository forecastWeatherRepository;

    /**
     * Save and return currentWeather
     * if weather already exist return entyty from database
     * @param currentWeather
     * @return  current weather
     */
    public CurrentWeather saveCurrentWeather(CurrentWeather currentWeather) {
        CurrentWeather stored = currentWeatherRepository.findByUpdateTimeEqualsAndCity(currentWeather.getUpdateTime(), currentWeather.getCity());
        if (stored == null) {
            return currentWeatherRepository.save(currentWeather);
        }else{
            return stored;
        }
    }

    /**
     * Get weather by last 28 days in database by cityId
     * @param cityId
     * @return list forecast weather
     */
    public List<ForecastWeather> getForecastWeather(Integer cityId) {
        return forecastWeatherRepository.findTop28ByCityIdOrderByFutureDateDesc(cityId).stream()
                .sorted(Comparator.comparing(ForecastWeather::getFutureDate)).collect(Collectors.toList());
    }

    /**
     * Save forecastWeather if not exist else update
     * @param forecastWeather
     * @return forecast weather
     */
    public ForecastWeather saveForecastWeather(ForecastWeather forecastWeather) {
        ForecastWeather weather = forecastWeatherRepository.findByFutureDateAndCity(forecastWeather.getFutureDate(),forecastWeather.getCity());
        if (weather != null) {
            weather.setMaxTemperature(forecastWeather.getMaxTemperature());
            weather.setMinTemperature(forecastWeather.getMinTemperature());
            weather.setSky(forecastWeather.getSky());
            return  forecastWeatherRepository.save(weather);
        }else{
            return forecastWeatherRepository.save(forecastWeather);
        }
    }
}

package com.tftest.demo.service.entity;

import com.tftest.demo.dto.ForecastWeatherDTO;
import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.repository.CurrentWeatherRepository;
import com.tftest.demo.repository.ForecastWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;
    @Autowired
    private ForecastWeatherRepository forecastWeatherRepository;

    public CurrentWeather saveCurrentWeather(CurrentWeather currentWeather){
        return currentWeatherRepository.save(currentWeather);
    }

    public boolean existCurrentWeatherByTime(LocalDateTime updateTime, City city){
        return currentWeatherRepository.existsCurrentWeatherByUpdateTimeEqualsAndCity(updateTime, city);
    }

    public List<ForecastWeatherDTO> getForecastWeather(Integer cityId){
        return forecastWeatherRepository.findByCityId(cityId).stream().map(forecastWeather
                -> new ForecastWeatherDTO(forecastWeather)).collect(Collectors.toList());
    }
}

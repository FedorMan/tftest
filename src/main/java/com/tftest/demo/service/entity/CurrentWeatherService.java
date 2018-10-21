package com.tftest.demo.service.entity;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.repository.CurrentWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CurrentWeatherService {

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;

    public CurrentWeather save(CurrentWeather currentWeather){
        return currentWeatherRepository.save(currentWeather);
    }

    public boolean existByTime(LocalDateTime updateTime, City city){
        return currentWeatherRepository.existsCurrentWeatherByUpdateTimeEqualsAndCity(updateTime, city);
    }
}

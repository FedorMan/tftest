package com.tftest.demo.service;

import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.repository.CurrentWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentWeatherService {

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;

    public CurrentWeather save(CurrentWeather currentWeather){
        return currentWeatherRepository.save(currentWeather);
    }
}

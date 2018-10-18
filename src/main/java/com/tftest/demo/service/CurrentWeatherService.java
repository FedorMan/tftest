package com.tftest.demo.service;

import com.tftest.demo.repository.CurrentWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentWeatherService {

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;
}

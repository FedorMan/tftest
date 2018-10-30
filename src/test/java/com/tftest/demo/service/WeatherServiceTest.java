package com.tftest.demo.service;

import com.tftest.demo.repository.CurrentWeatherRepository;
import com.tftest.demo.repository.ForecastWeatherRepository;
import com.tftest.demo.service.entity.WeatherService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class WeatherServiceTest {
    @InjectMocks
    private WeatherService weatherService;
    @MockBean
    private CurrentWeatherRepository currentWeatherRepository;
    @MockBean
    private ForecastWeatherRepository forecastWeatherRepository;

    @Before
    public void setUp(){
    }
}

package com.tftest.demo.integration;

import com.tftest.demo.service.WeatherIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class IntegrationScheduler {

    @Autowired
    public WeatherIntegrationService weatherIntegrationService;

    //http://www.cronmaker.com/
    @Scheduled(cron = "0 0 0/1 1/1 * ? *")
    public void loadCurrentWeather(){
        weatherIntegrationService.loadCurrentWeather();
    }
}

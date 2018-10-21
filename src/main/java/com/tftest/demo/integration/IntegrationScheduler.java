package com.tftest.demo.integration;

import com.tftest.demo.service.integration.WeatherIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class IntegrationScheduler {

    @Autowired
    public WeatherIntegrationService weatherIntegrationService;

//    @Scheduled(fixedRate = 10)
    @Scheduled(cron = "0 0 */1 * * *")
    public void loadCurrentWeather(){
        weatherIntegrationService.loadCurrentWeather();
    }
}

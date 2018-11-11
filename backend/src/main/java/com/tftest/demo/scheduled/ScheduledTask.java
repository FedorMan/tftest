package com.tftest.demo.scheduled;

import com.tftest.demo.service.integration.WeatherIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled tasks
 */
@Component
public class ScheduledTask {

    @Autowired
    public WeatherIntegrationService weatherIntegrationService;

    /**
     * update weather every hour
     */
//    @Scheduled(fixedRate = 10)
    @Scheduled(cron = "0 0 */1 * * *")
    public void loadCurrentWeather(){
        weatherIntegrationService.loadWeather();
    }
}

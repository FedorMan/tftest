package com.tftest.demo.scheduled;

import com.tftest.demo.service.integration.WeatherIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Autowired
    public WeatherIntegrationService weatherIntegrationService;

//    @Scheduled(fixedRate = 10)
    @Scheduled(cron = "0 0 */1 * * *")
    public void loadCurrentWeather(){
        weatherIntegrationService.loadWeather();
    }

    //каждый день в 1:00 рассчитывать данные предыдущего дня из того что было собрано в течении часов
    @Scheduled(cron = "0 0 1 * * *")
    public void calculateLastDay(){

    }
}

package com.tftest.demo.controller.WeatherController;

import com.tftest.demo.dto.CityDTO;
import com.tftest.demo.dto.ForecastWeatherDTO;
import com.tftest.demo.service.entity.CityService;
import com.tftest.demo.service.entity.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("weather")
public class WeatherController {

    @Autowired
    private CityService cityService;
    @Autowired
    private WeatherService weatherService;


    @GetMapping("/cities")
    public List<CityDTO> getCities(){
        return cityService.getCities();
    }

//    @GetMapping("/forecast/{city}")
//    public List<ForecastWeatherDTO> getForecastWeather(){
//
//    }

}

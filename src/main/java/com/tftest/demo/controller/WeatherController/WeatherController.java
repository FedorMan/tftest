package com.tftest.demo.controller.WeatherController;

import com.tftest.demo.dto.CityDTO;
import com.tftest.demo.dto.ForecastWeatherDTO;
import com.tftest.demo.service.entity.CityService;
import com.tftest.demo.service.entity.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private CityService cityService;
    @Autowired
    private WeatherService weatherService;


    @GetMapping("/current")
    public List<CityDTO> getCities(){
        return cityService.getCities().stream().map(CityDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/forecast/{cityId}")
    public List<ForecastWeatherDTO> getForecastWeather(@PathVariable Integer cityId){
        return weatherService.getForecastWeather(cityId).stream().map(ForecastWeatherDTO::new).collect(Collectors.toList());
    }
}

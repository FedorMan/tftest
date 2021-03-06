package com.tftest.demo.controller.WeatherController;

import com.tftest.demo.dto.CityDTO;
import com.tftest.demo.dto.ForecastWeatherDTO;
import com.tftest.demo.exception.ResourceNotFoundException;
import com.tftest.demo.service.entity.CityService;
import com.tftest.demo.service.entity.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for get weather
 */
@RestController()
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private CityService cityService;
    @Autowired
    private WeatherService weatherService;


    /**
     *
     * @return city params and current weather on this city
     */
    @GetMapping("/current")
    public List<CityDTO> getCities(){
        return cityService.getCities().stream().map(CityDTO::new).collect(Collectors.toList());
    }

    /**
     *
     * @param cityId
     * @return forecast weather list for select city by id
     */
    @GetMapping("/forecast/{cityId}")
    public List<ForecastWeatherDTO> getForecastWeather(@PathVariable Integer cityId){
        List<ForecastWeatherDTO> responce = weatherService.getForecastWeather(cityId).stream().map(ForecastWeatherDTO::new).collect(Collectors.toList());
        if (responce.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return responce;
    }
}

package com.tftest.demo.service.external.weather.impl;

import com.tftest.demo.dto.YahooWeatherDTO;
import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.entity.ForecastWeather;
import com.tftest.demo.service.external.weather.ExternalWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class YahooExternalWeatherService implements ExternalWeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${yahoo.api.url}")
    private String url;
    @Value("${yahoo.api.query}")
    private String query;

    @Override
    public CurrentWeather loadCurrentWeather(City city) {
        CurrentWeather currentWeather = getWeather(city).getCurrentWeather();
        currentWeather.setCity(city);
        return currentWeather;
    }

    @Override
    public List<ForecastWeather> loadForecastWeather(City city) {
        List<ForecastWeather> forecastWeathers = getWeather(city).getForecastWeather();
        forecastWeathers.forEach(forecastWeather -> forecastWeather.setCity(city));
        return forecastWeathers;
    }

    private YahooWeatherDTO getWeather(City city){
        URI targetUrl = UriComponentsBuilder.fromUriString(url)
                .queryParam("q", query.replace("{city_id}", String.valueOf(city.getId())))
                .build()
                .encode()
                .toUri();
        YahooWeatherDTO yahooWeatherDTO = restTemplate.getForObject(targetUrl, YahooWeatherDTO.class);
        return yahooWeatherDTO;
    }


}

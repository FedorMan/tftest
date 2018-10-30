package com.tftest.demo.service.entity;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.entity.ForecastWeather;
import com.tftest.demo.repository.CurrentWeatherRepository;
import com.tftest.demo.repository.ForecastWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;
    @Autowired
    private ForecastWeatherRepository forecastWeatherRepository;

    public CurrentWeather saveCurrentWeather(CurrentWeather currentWeather) {
        if (!existCurrentWeatherByTime(currentWeather.getUpdateTime(), currentWeather.getCity())) {
            return currentWeatherRepository.save(currentWeather);
        }else{
            return currentWeather;
        }
    }

    public boolean existCurrentWeatherByTime(LocalDateTime updateTime, City city) {
        return currentWeatherRepository.existsCurrentWeatherByUpdateTimeEqualsAndCity(updateTime, city);
    }

    public List<ForecastWeather> getForecastWeather(Integer cityId) {
        return forecastWeatherRepository.findTop28ByCityIdOrderByFutureDateDesc(cityId).stream()
                .sorted(Comparator.comparing(ForecastWeather::getFutureDate)).collect(Collectors.toList());
    }

    public ForecastWeather saveForecastWeather(ForecastWeather forecastWeather) {
        ForecastWeather weather = forecastWeatherRepository.findByFutureDateAndCity(forecastWeather.getFutureDate(),forecastWeather.getCity());
        if (weather != null) {
            weather.setMaxTemperature(forecastWeather.getMaxTemperature());
            weather.setMinTemperature(forecastWeather.getMinTemperature());
            weather.setSky(forecastWeather.getSky());
            return  forecastWeatherRepository.save(weather);
        }else{
            return forecastWeatherRepository.save(forecastWeather);
        }
    }
}

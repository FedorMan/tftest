package com.tftest.demo.repository;

import com.tftest.demo.entity.ForecastWeather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForecastWeatherRepository extends JpaRepository<ForecastWeather,Integer> {
    public List<ForecastWeather> findByCityId(Integer cityId);
}

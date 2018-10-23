package com.tftest.demo.repository;

import com.tftest.demo.entity.ForecastWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForecastWeatherRepository extends JpaRepository<ForecastWeather,Integer> {
}

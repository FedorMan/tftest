package com.tftest.demo.repository;

import com.tftest.demo.entity.ForecastWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForecastWeatherRepository extends JpaRepository<ForecastWeather,Integer> {
    public List<ForecastWeather> findTop28ByCityIdOrderByFutureDateDesc(Integer cityId);
}

package com.tftest.demo.repository;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CurrentWeatherRepository extends JpaRepository<CurrentWeather,Integer> {
    boolean existsCurrentWeatherByUpdateTimeEqualsAndCity(LocalDateTime updateTime, City city);
}

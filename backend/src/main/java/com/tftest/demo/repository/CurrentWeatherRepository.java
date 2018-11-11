package com.tftest.demo.repository;

import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * JPA repository for entity current weather
 */
@Repository
public interface CurrentWeatherRepository extends JpaRepository<CurrentWeather,Integer> {
    /**
     * Return current weather if exist by time and city
     * @param localDateTime
     * @param city
     * @return current weather if exist else null
     */
    CurrentWeather findByUpdateTimeEqualsAndCity(LocalDateTime localDateTime, City city);
}

package com.tftest.demo.repository;

import com.tftest.demo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for entity city
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}

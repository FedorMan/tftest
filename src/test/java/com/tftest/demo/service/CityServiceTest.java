package com.tftest.demo.service;

import com.tftest.demo.entity.City;
import com.tftest.demo.repository.CityRepository;
import com.tftest.demo.service.entity.CityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CityServiceTest {
    @InjectMocks
    private CityService cityService;
    @MockBean
    private CityRepository cityRepository;

    @Before
    public void setUp(){
        List<City> cities = new ArrayList<>();
        cities.add(new City(1,"Samara","ddd",null,null));
        cities.add(new City(2,"Moscow","ddd",null,null));
        cities.add(new City(3,"SP","ddd",null,null));

        Mockito.when(cityRepository.findAll()).thenReturn(cities);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validGetCities(){
        assertEquals(cityService.getCities().size(), 3);
    }

    @Test
    public void validEqualsCities(){
        List<City> cities = cityService.getCities();
        City city = cities.stream().filter(c -> c.getName().equals("Samara")).findFirst().get();
        assertEquals(city.getPathToImg(), "ddd");
    }
}

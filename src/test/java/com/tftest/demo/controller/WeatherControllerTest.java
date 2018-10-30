package com.tftest.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tftest.demo.DemoApplication;
import com.tftest.demo.dto.CityDTO;
import com.tftest.demo.dto.ForecastWeatherDTO;
import com.tftest.demo.entity.City;
import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.entity.ForecastWeather;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SqlGroup({
        @Sql(value = "classpath:sql/weather_insert_test_data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        @Sql(value = "classpath:sql/weather_delete_test_data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
public class WeatherControllerTest {
    private static final String REST_API_URL = "http://localhost:8080/weather/";
    private static final String REST_API_METHOD_CURRENT = "current/";
    private static final String REST_API_METHOD_FORECAST_200_OK = "forecast/111";
    private static final String REST_API_METHOD_FORECAST_404_NOT_FOUND = "forecast/1111";

    private CityDTO cityDTO;
    private List<ForecastWeatherDTO> forecastWeatherDTOs;

    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        ForecastWeather forecastWeather = new ForecastWeather(888, -100, LocalDate.of(2018, 10, 29), "Cloudy");
        forecastWeather.setId(1);
        List<ForecastWeather> forecastWeathers = new ArrayList<ForecastWeather>();
        forecastWeathers.add(forecastWeather);
        CurrentWeather currentWeather = new CurrentWeather(900, 0, LocalDateTime.of(2018, 10, 29, 0, 0));
        List<CurrentWeather> currentWeathers = new ArrayList<CurrentWeather>();
        currentWeathers.add(currentWeather);
        City city = new City(111, "Hogwast", "aaa", currentWeathers, forecastWeathers, null);
        cityDTO = new CityDTO(city);
        forecastWeatherDTOs = forecastWeathers.stream().map(ForecastWeatherDTO::new).collect(Collectors.toList());
    }

    @Test
    public void testCurrentWeather() throws Exception {
        String json = mockMvc.perform(get(REST_API_URL + REST_API_METHOD_CURRENT))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        List<CityDTO> response = Arrays.asList(new ObjectMapper().readValue(json, CityDTO[].class));
        assertEquals(response.get(0), cityDTO);
    }

    @Test
    public void testForecastWeatherPositive() throws Exception {
        String json = mockMvc.perform(get(REST_API_URL + REST_API_METHOD_FORECAST_200_OK))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        List<ForecastWeatherDTO> response = Arrays.asList(new ObjectMapper().readValue(json, ForecastWeatherDTO[].class));
        assertEquals(response, forecastWeatherDTOs);
    }

    @Test
    public void testForecastWeatherNegative() throws Exception {
        mockMvc.perform(get(REST_API_URL + REST_API_METHOD_FORECAST_404_NOT_FOUND))
                .andExpect(status().isNotFound());
    }
}

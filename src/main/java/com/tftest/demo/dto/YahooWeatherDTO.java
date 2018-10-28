package com.tftest.demo.dto;

import com.tftest.demo.entity.CurrentWeather;
import com.tftest.demo.entity.ForecastWeather;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

class Query{
    public Results results;
}

class Results{
    public Channel channel;
}

class Channel{
    public Wind wind;
    public Item item;
}

class Wind{
    public String speed;
    public String direction;
    public String chill;
}

class Item{
    public Condition condition;
    public List<YahooForecastWeather> forecast;
}

class Condition{
    public String date;
    public String temp;
}

class YahooForecastWeather{
    public String date;
    public String high;
    public String low;
    public String text;
}

@Data
public class YahooWeatherDTO {
    public Query query;

    public CurrentWeather getCurrentWeather(){
        CurrentWeather currentWeather = new CurrentWeather();
        currentWeather.setTemperature(fToC(Double.parseDouble(query.results.channel.item.condition.temp)));
        currentWeather.setWindSpeed(mphToMs(Double.parseDouble(query.results.channel.wind.speed)));
        String date = query.results.channel.item.condition.date;
        date = date.substring(0,date.lastIndexOf(' '));
        currentWeather.setUpdateTime(LocalDateTime.parse(date, DateTimeFormatter.ofPattern("EEE, dd MMM yyyy hh:mm a", Locale.US)));
        return currentWeather;
    }

    public List<ForecastWeather> getForecastWeather(){
        List<ForecastWeather> forecastWeathers = new ArrayList<>();
        if(query.results.channel.item.forecast != null){
            query.results.channel.item.forecast.forEach(yahooForecastWeather -> {
                LocalDate date = LocalDate.parse(yahooForecastWeather.date, DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.US));
                ForecastWeather weather = new ForecastWeather(fToC(Double.parseDouble(yahooForecastWeather.high)), fToC(Double.parseDouble(yahooForecastWeather.low)), date, yahooForecastWeather.text);
                forecastWeathers.add(weather);
            });
        }
        return forecastWeathers;
     }

    //(Фаренгейт — 32) : 1,8 = Цельсий
    private double fToC(double f){
        return (f - 32) / 1.8;
    }

    private double mphToMs(double mph){
        return mph / 2.337;
    }
}
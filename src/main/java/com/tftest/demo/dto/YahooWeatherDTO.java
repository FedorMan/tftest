package com.tftest.demo.dto;

import com.tftest.demo.entity.CurrentWeather;
import lombok.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
}

class Condition{
//    @JsonProperty("EEE, dd MMM yyyy hh:mm a ZZZZ")
    public String date;
    public String temp;
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

    //(Фаренгейт — 32) : 1,8 = Цельсий
    private double fToC(double f){
        return (f - 32) / 1.8;
    }

    private double mphToMs(double mph){
        return mph / 2.337;
    }
}
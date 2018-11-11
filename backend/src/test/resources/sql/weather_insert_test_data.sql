TRUNCATE forecast_weather cascade;
TRUNCATE current_weather cascade;
TRUNCATE city cascade;

insert into city values(111,'Hogwast', 'aaa');

insert into forecast_weather(id, city_id, max_temperature, min_temperature, future_date, sky)
values(1 , 111, 888, -100, to_date('2018-10-29', 'YYYY-MM-DD'),'Cloudy');

insert into  current_weather(city_id, temperature, wind_speed, update_time)
values(111, 900, 0, to_date('2018-10-29', 'YYYY-MM-DD'));
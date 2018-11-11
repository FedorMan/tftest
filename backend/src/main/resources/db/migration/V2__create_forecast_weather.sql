create table forecast_weather(
  id serial primary key,
  city_id integer references city(id),
  max_temperature double precision,
  min_temperature double precision,
  future_date date
);

create index date_index on forecast_weather(future_date);
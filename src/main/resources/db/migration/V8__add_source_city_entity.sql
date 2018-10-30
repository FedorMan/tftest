create table city_on_source_weather(
  id serial primary key,
  city_id integer references city(id),
  source varchar(15),
  city_id_on_source varchar(15)
);

insert into city_on_source_weather(city_id,source,city_id_on_source) values (2077746,'yahoo','2077746');
insert into city_on_source_weather(city_id,source,city_id_on_source) values (2122265,'yahoo','2122265');
insert into city_on_source_weather(city_id,source,city_id_on_source) values (2123260,'yahoo','2123260');
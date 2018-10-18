create table city(
  id integer primary key,
  name varchar(20)
);

insert into city values(2077746,'Samara');
insert into city values(2122265,'Moscow');
insert into city values(2123260,'Saint Petersburg');

create table current_weather(
  id serial primary key,
  city_id integer references city(id),
  wind_speed double precision,
  temperature double precision,
  update_time date
);

create index update_time_index on current_weather(update_time);
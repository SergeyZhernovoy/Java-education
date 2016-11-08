--create transmission
create table transmission(
   transmission_id serial primary key,
   name varchar(150) NOT NULL,
   type_transmission smallint NOT NULL
);


--create engine
create table engine(
   engine_id serial primary key,
   name varchar(150) NOT NULL,
   type_engine smallint NOT NULL
);

--create box
create table gear_box(
   gear_box_id serial primary key, 
   name varchar(150) NOT NULL,
   type_box smallint NOT NULL
);

--create carcreate table gear_box(
create table car(
   car_id serial primary key,
   name varchar(150) NOT NULL,
   box_id integer references  gear_box(gear_box_id),
   engine_id integer references   engine(engine_id),
   transm_id integer references  transmission(transmission_id)
   
);

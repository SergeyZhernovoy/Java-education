\connect users
--table author

create table if not exists city(
    city_id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE
);

create table if not exists country(
    country_id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE
);

create table if not exists users(
    users_id serial primary key NOT NULL,
    email CHARACTER VARYING (150) NOT NULL,
    login CHARACTER VARYING(25),
    create_date TIMESTAMP without time ZONE,
    password CHARACTER VARYING(25) NOT NULL,
    city INTEGER REFERENCES city(city_id),
    country INTEGER REFERENCES country(country_id)
);

INSERT INTO public.country(name)  VALUES ('Russia');
INSERT INTO public.country(name)  VALUES ('USA');
INSERT INTO public.country(name)  VALUES ('Ukraine');
INSERT INTO public.country(name)  VALUES ('Belarussia');
INSERT INTO public.country(name)  VALUES ('Estonia');

INSERT INTO public.city(name)   VALUES ('Penza');
INSERT INTO public.city(name)   VALUES ('Tallin');
INSERT INTO public.city(name)   VALUES ('Moscow');
INSERT INTO public.city(name)   VALUES ('Kiev');
INSERT INTO public.city(name)   VALUES ('Minsk');



\connect users
--table author
create table if not exists role(
    role_id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE ,
    root boolean
);


create table if not exists city(
    city_id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE ,

);


create table if not exists country(
    country_id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE ,

);

create table if not exists users(
    users_id serial primary key NOT NULL,
    name  CHARACTER VARYING (250) NOT NULL,
    email CHARACTER VARYING (150) NOT NULL,
    login CHARACTER VARYING(25),
    create_date TIMESTAMP without time ZONE,
    password CHARACTER VARYING(25) NOT NULL,
    role INTEGER REFERENCES role(role_id),
    city INTEGER REFERENCES city(city_id),
    country INTEGER REFERENCES country(country_id),

);






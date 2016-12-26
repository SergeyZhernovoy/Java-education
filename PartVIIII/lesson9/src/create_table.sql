\connect dao
--table author

create table if not exists address(
    id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE
);

create table if not exists musictype(
    id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE
);

create table if not exists role(
    id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE
);

create table if not exists users(
    users_id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE
    role INTEGER REFERENCES role(id),
    musictype INTEGER REFERENCES musictype(id),
    address INTEGER REFERENCES address(id)
);

/*
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
*/


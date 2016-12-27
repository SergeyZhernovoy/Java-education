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
    id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE
    role INTEGER REFERENCES role(id),
    musictype INTEGER REFERENCES musictype(id),
    address INTEGER REFERENCES address(id)
);


INSERT INTO role(name)  VALUES ('USER');
INSERT INTO role(name)  VALUES ('MANDATOR');
INSERT INTO role(name)  VALUES ('ADMIN');


INSERT INTO musictype(name)   VALUES ('RAP');
INSERT INTO musictype(name)   VALUES ('ROCK');
INSERT INTO musictype(name)   VALUES ('BLUZ');


\connect users
--table author
create table if not exists users(
    users_id serial primary key NOT NULL,
    name  CHARACTER VARYING (250) NOT NULL,
    email CHARACTER VARYING (150) NOT NULL,
    login CHARACTER VARYING(25),
    create_date TIMESTAMP without time ZONE
);

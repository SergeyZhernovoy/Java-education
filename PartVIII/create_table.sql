create table users(
  id serial primary key,
  login character varying(2000),
  password character varying(2000),
  create_date timestamp
);
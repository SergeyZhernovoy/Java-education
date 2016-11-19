\connect vacancy
--table author
create table if not exists author(
    author_id serial primary key NOT NULL,
    linkAuthor text NOT NULL, 
    nameAuthor character varying(50)
);
--table vacancy
create table if not exists vacancy(
    vacancy_id serial primary key NOT NULL,
    vacancy_name character varying NOT NULL,
    vacancy_link text,
    ask integer,
    answer integer,
    last_update timestamp,
    author_id integer references author(author_id) NOT NULL
);

-- table work
create table if not exists work(
     time_id serial primary key NOT NULL,
     lastDate timestamp NOT NULL
);

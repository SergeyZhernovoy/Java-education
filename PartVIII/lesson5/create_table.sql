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


CREATE OR REPLACE RULE work_insert AS ON INSERT
TO work
WHERE (EXISTS
      ( SELECT 1
        FROM work AS work_1
        WHERE work_1.time_id IS NOT NULL))
DO INSTEAD
   UPDATE work
          SET lastdate = new.lastdate;

CREATE OR REPLACE RULE vacancy_insert AS ON INSERT
TO vacancy
WHERE (EXISTS
      (SELECT 1
       FROM vacancy
       WHERE vacancy.vacancy_name = NEW.vacancy_name AND  vacancy.author_id = NEW.author_id))
DO INSTEAD
UPDATE vacancy SET
		vacancy_link = NEW.vacancy_link,
		ask = NEW.ask,
		answer= NEW.answer,
		last_update=  NEW.last_update
		WHERE vacancy.vacancy_name = NEW.vacancy_name AND  vacancy.author_id = NEW.author_id
create table if not exists task (
   task_id serial primary key,
   name varchar(25) NOT NULL, 
   description varchar (150),
   create_date timestamp NOT NULL 
 );

 create table  if not exists commentary(
   comm_id serial primary key,
   comment text,
   task_id integer references task(task_id)
 );
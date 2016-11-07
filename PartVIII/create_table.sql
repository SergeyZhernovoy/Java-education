\connect mybase
--table status
create table status_order(
	status_id smallserial primary key,
	name character varying (25)
);

-- table type_order
create table type_order(
	type_id smallserial primary key,
	name character varying (25)
);

-- table role right
create table role_rights(
	rights_id serial primary key,
	write boolean,
	read boolean
); 

-- table role 
create table role(
	role_id serial primary key,
	name character varying (25),
	rights_id integer references role_rights(rights_id)
);

-- table user 
create table users(
	user_id serial primary key,
	login character varying (100),
	password character varying (100),
	create_date timestamp,
	role_id integer references role(role_id)
);

-- table orders 
create table orders(
	order_id serial primary key,
	date_order timestamp,
	number_order character (10), 
	type_id integer references type_order(type_id),
	status_id integer references status_order(status_id),
	user_id integer references users(user_id)
);

-- table commentary
create table commentary_orders(
	comment_id serial primary key,
	message character varying (2000),
	order_id integer references orders(order_id)
);

-- table attach files
create table attached_files_orders(
	attached_id serial primary key,
	file_path character varying (2000),
	order_id integer references orders(order_id)
);

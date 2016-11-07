\connect mybase
INSERT INTO type_order(
type_id, name)
VALUES (1,'buy');

INSERT INTO type_order(
type_id, name)
VALUES (2, 'sale');

INSERT INTO status_order(
status_id, name)
VALUES (1, 'new');

INSERT INTO status_order(
status_id, name)
VALUES (2, 'in proccess');

INSERT INTO status_order(
status_id, name)
VALUES (3, 'close');

INSERT INTO status_order(
status_id, name)
VALUES (4, 'reject');

INSERT INTO role_rights(
rights_id, write, read)
VALUES (1, true, false);

INSERT INTO role_rights(
rights_id, write, read)
VALUES (2, false, true);

INSERT INTO role_rights(
rights_id, write, read)
VALUES (3, true, true);

INSERT INTO role_rights(
rights_id, write, read)
VALUES (4, false, false);

INSERT INTO role(
role_id, name, rights_id)
VALUES (1, 'administrator', 3);

INSERT INTO role(
role_id, name, rights_id)
VALUES (2, 'manager', 2);

INSERT INTO users(
user_id, login, password, create_date, role_id)
VALUES (1, 'Sergey Zhernovoy', '12345', '2016-11-07 04:05:06', 1);

INSERT INTO users(
user_id, login, password, create_date, role_id)
VALUES (2, 'Aleskey Tishkin', '12345', '2016-11-07 04:05:06', 2);

INSERT INTO orders(
order_id, date_order, number_order, type_id, status_id, user_id)
VALUES (1, '2016-11-07 04:05:06', '1', 1, 1, 1);

INSERT INTO orders(
order_id, date_order, number_order, type_id, status_id, user_id)
VALUES (2, '2016-10-07 04:05:06', '2', 1, 2, 1);

INSERT INTO orders(
order_id, date_order, number_order, type_id, status_id, user_id)
VALUES (3, '2016-11-04 04:05:06', '3', 2, 3, 1);

INSERT INTO orders(
order_id, date_order, number_order, type_id, status_id, user_id)
VALUES (4, '2016-11-03 04:05:06', '4', 1, 4, 2);

INSERT INTO orders(
order_id, date_order, number_order, type_id, status_id, user_id)
VALUES (5, '2016-11-05 04:05:06', '5', 2, 1, 2);

INSERT INTO orders(
order_id, date_order, number_order, type_id, status_id, user_id)
VALUES (6, '2016-11-02 04:05:06', '6', 1, 3, 1);

INSERT INTO orders(
order_id, date_order, number_order, type_id, status_id, user_id)
VALUES (7, '2016-11-01 04:05:06', '7', 2, 4, 2);

INSERT INTO commentary_orders(
comment_id, message, order_id)
VALUES (1, 'he wants lose weight', 1);

INSERT INTO commentary_orders(
comment_id, message, order_id)
VALUES (2, 'Baseball pig', 2);

INSERT INTO commentary_orders(
comment_id, message, order_id)
VALUES (3, 'There is a fat man', 5);

INSERT INTO commentary_orders(
comment_id, message, order_id)
VALUES (4, 'The man is very fat', 5);

INSERT INTO attached_files_orders(
    attached_id, file_path, order_id)
VALUES (1, 'c:\windows', 1);
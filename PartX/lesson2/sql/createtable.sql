create table if not exists body(
    id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE
);

create table if not exists drivetype(
    id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE
);

create table if not exists engine(
    id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE
);

create table if not exists model(
    id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE

);

create table if not exists transmission(
    id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL UNIQUE
);

create table if not exists car(
    id serial primary key NOT NULL,
    name  CHARACTER VARYING (50) NOT NULL,
    id_body INTEGER REFERENCES body(id),
    id_drivetype INTEGER REFERENCES drivetype(id),
    id_engine INTEGER REFERENCES engine(id),
    id_model INTEGER REFERENCES model(id),
    id_transmission INTEGER REFERENCES transmission(id)
);

create table if not exists users(
    id serial primary key NOT NULL,
    login  CHARACTER VARYING (50) NOT NULL UNIQUE,
    pass   CHARACTER VARYING (50)
);


create table if not exists orders(
    id serial primary key NOT NULL,
    sold BOOLEAN,
    mileage INTEGER ,
    price   INTEGER,
    realise TIMESTAMP ,
    id_car  INTEGER REFERENCES car(id) NOT NULL,
    id_user INTEGER REFERENCES users(id) NOT NULL
);

create table if not exists image(
    id serial primary key NOT NULL,
    dataimage bytea  NOT NULL,
    id_orders INTEGER REFERENCES orders(id) NOT NULL
);

INSERT INTO body(name)  VALUES ('седан');
INSERT INTO body(name)  VALUES ('хэтчбек');
INSERT INTO body(name)  VALUES ('универсал');
INSERT INTO body(name)  VALUES ('внедорожник');
INSERT INTO body(name)  VALUES ('кабриолет');
INSERT INTO body(name)  VALUES ('купе');
INSERT INTO body(name)  VALUES ('лимузин');
INSERT INTO body(name)  VALUES ('минивэн');
INSERT INTO body(name)  VALUES ('пикап');
INSERT INTO body(name)  VALUES ('фургон');
INSERT INTO body(name)  VALUES ('микроавтобус');

INSERT INTO drivetype(name)  VALUES ('передний');
INSERT INTO drivetype(name)  VALUES ('задний');
INSERT INTO drivetype(name)  VALUES ('полный');

INSERT INTO engine(name)  VALUES ('бензин');
INSERT INTO engine(name)  VALUES ('дизель');
INSERT INTO engine(name)  VALUES ('гибрид');
INSERT INTO engine(name)  VALUES ('электро');
INSERT INTO engine(name)  VALUES ('газ');

INSERT INTO model(name)  VALUES ('audi');
INSERT INTO model(name)  VALUES ('bmw');
INSERT INTO model(name)  VALUES ('chevrolet');
INSERT INTO model(name)  VALUES ('citroen');
INSERT INTO model(name)  VALUES ('ford');
INSERT INTO model(name)  VALUES ('honda');
INSERT INTO model(name)  VALUES ('lexus');
INSERT INTO model(name)  VALUES ('mazda');
INSERT INTO model(name)  VALUES ('opel');
INSERT INTO model(name)  VALUES ('nissan');
INSERT INTO model(name)  VALUES ('volvo');

INSERT INTO transmission(name)  VALUES ('механика');
INSERT INTO transmission(name)  VALUES ('автомат');
INSERT INTO transmission(name)  VALUES ('робот');
INSERT INTO transmission(name)  VALUES ('вариатор');


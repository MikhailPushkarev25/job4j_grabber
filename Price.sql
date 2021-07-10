create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into people(name) values('Алексей');
insert into people(name) values('Роман');
insert into people(name) values('Василий');
insert into people(name) values('Елена');
insert into people(name) values('Виктория');
insert into people(name) values('Евгений');

insert into devices(name, price) values('phone', 1000);
insert into devices(name, price) values('TV', 1500);
insert into devices(name, price) values('calculate', 350);
insert into devices(name, price) values('Ps', 30000);

insert into devices_people(device_id, people_id) values(1, 1);
insert into devices_people(device_id, people_id) values(1, 2);
insert into devices_people(device_id, people_id) values(2, 2);
insert into devices_people(device_id, people_id) values(2, 4);
insert into devices_people(device_id, people_id) values(4, 2);
insert into devices_people(device_id, people_id) values(3, 3);

select avg(price) from devices;

select p.name, avg(d.price) from devices_people as dp join devices as d on dp.device_id = d.id join
people as p on dp.people_id = d.id
group by p.name;

select p.name, avg(d.price) from devices_people as dp join devices as d on dp.device_id = d.id join
people as p on dp.people_id = d.id
group by p.name
having avg(d.price) > 5000;

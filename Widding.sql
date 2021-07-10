create table woman(
	id serial primary key,
	name varchar(255)
);

create table man(
	id serial primary key,
	name varchar(255)
);

create table marriage(
	id serial primary key,
	woman_id int references woman(id),
	man_id int references man(id),
	date varchar(255)
);

insert into woman(name) values('Виктория');
insert into woman(name) values('Александра');
insert into woman(name) values('Мария');

insert into man(name) values('Михаил');
insert into man(name) values('Роман');
insert into man(name) values('Алексей');
insert into man(name) values('Василий');

insert into marriage(woman_id, man_id, date) values(1, 2, '20.02.2020');
insert into marriage(woman_id, man_id, date) values(2, 1, '01.07.2021');
insert into marriage(woman_id, man_id, date) values(3, 2, '10.10.2010');

// вывод дат когда женщины вышли замуж
select w.name, d.date from woman as w join marriage as d on d.woman_id = w.id;

// вывод дат женщина с мужчиной из списка вышли женились
select w.name as имя, m.name as имя, d.date as дата from woman as w join marriage as d on d.woman_id = w.id
join man as m on d.man_id = m.id;

// вывод даты '10.10.2010' - кто женился
select w.name as имя, m.name as имя, d.date as дата from woman as w join marriage as d on d.woman_id = w.id
join man as m on (d.man_id = m.id and d.date = '10.10.2010');


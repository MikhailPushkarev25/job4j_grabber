// Many to one

create table student(
	id serial primary key,
	name varchar(255)
);

create table school(
	id serial primary key,
	name varchar(255),
	student_id int references student(id)
);

insert into student(name) values('Вася');
insert into student(name) values('Леша');

insert into school(name, student_id) values('Математика', 1);
insert into school(name, student_id) values('Литература', 2);

select * from school;

select * from student where id in (select id from school);

// one to one

create table engine(
	id serial primary key,
	power int
);

create table auto(
	id serial primary key,
	engine_id int references engine(id) unique
);

insert into engine(power) values(250);

insert into auto(engine_id) values(1);

select * from engine where id in (select id from auto);

// many to many

create table products(
	id serial primary key,
	name varchar(255)
);

create table humen(
	id serial primary key,
	name varchar(255)
);

create table products_humen(
	id serial primary key,
	name varchar(255),
	humen_id int references humen(id),
	products_id int references products(id)
);

insert into products(name) values('Картошка');
insert into products(name) values('Хлеб');
insert into products(name) values('Молоко');

insert into humen(name) values('Василий');
insert into humen(name) values('Алексей');
insert into humen(name) values('Дмитрий');

insert into products_humen(name, humen_id, products_id) values('1', 1, 1);
insert into products_humen(name, humen_id, products_id) values('2', 2, 2);
insert into products_humen(name, humen_id, products_id) values('3', 3, 3);

select * from humen, products, products_humen;

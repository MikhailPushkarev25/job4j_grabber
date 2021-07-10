create table material(
	id serial primary key,
	number int
);

create table goods(
	id serial primary key,
	name varchar(255),
	materials_id int references material(id) unique
);

insert into material(number) values(2);
insert into material(number) values(5);
insert into material(number) values(1);

insert into goods(name, materials_id) values ('armature', 2);
insert into goods(name, materials_id) values ('glass', 3);
insert into goods(name, materials_id) values ('body', 1);

select * from goods join material m on goods.materials_id = m.id;
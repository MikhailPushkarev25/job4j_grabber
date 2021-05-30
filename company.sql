Create table company(
	id integer not null,
	name character varying,
	CONSTRAINT company_key PRIMARY KEY (id)
);

create table person(
	id integer not null,
	name character varying,
	company_id integer,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1111, 'company1');
insert into company(id, name) values (2222, 'company2');
insert into company(id, name) values (3333, 'company3');
insert into company(id, name) values (4444, 'company4');
insert into company(id, name) values (5555, 'company5');

insert into person(id, name, company_id) values (1111, 'name1', 1);
insert into person(id, name, company_id) values (2222, 'name2', 2);
insert into person(id, name, company_id) values (3333, 'name3', 3);
insert into person(id, name, company_id) values (4444, 'name4', 4);
insert into person(id, name, company_id) values (5555, 'name5', 5);
insert into person(id, name, company_id) values (6666, 'name6', 6);

select * from company;
select * from person;

select p.name company, c.name person from person p join company c on p.company_id = c.id where p.company_id != 5;
select c.name company, count(c.name) person_count
from person p join company c  on p.company_id = c.id
group by c.name
order by person_count desc
limit 1;




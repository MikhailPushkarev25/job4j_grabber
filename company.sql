Есть таблица встреч (id, имя), есть таблица юзеров (id, имя).

Нужно доработать модель базы данных, чтобы пользователи учавствовать во встречах.
У каждого участника встречи может быть разный статус участия - например подтвердил участие, отклонил.

create table users(
	id serial primary key,
	name varchar(100)
);

create table meeting(
	id serial primary key,
	name varchar(100)
);

create table users_meeting(
	users_id int references users(id),
	meeting_id int references meeting(id),
	name varchar(100)
);

insert into users(name) values ('users1');
insert into users(name) values ('users2');
insert into users(name) values ('users3');

insert into meeting(name) values ('meeting1');
insert into meeting(name) values ('meeting2');
insert into meeting(name) values ('meeting3');

insert into users_meeting(users_id, meeting_id, name) values (1, 1, 'подтвержден');
insert into users_meeting(users_id, meeting_id, name) values (1, 2, 'нет');
insert into users_meeting(users_id, meeting_id, name) values (1, 3, 'нет');
insert into users_meeting(users_id, meeting_id, name) values (2, 2, 'подтвержден');
insert into users_meeting(users_id, meeting_id, name) values (2, 3, 'нет');
insert into users_meeting(users_id, meetng_id, name) values (3, 3, 'подтвержден');

Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников.

select n.name, count(n.name) from meeting as n
join users_meeting as num on n.id = num.meeting_id and num.name = 'подтвержден' group by n.name;

Нужно получить все встречи, где не было ни заявки на посещение

select n.name from meeting AS n
 left join users_meeting as num on n.id = num.meeting_id;
CREATE TABLE users(
   id serial PRIMARY KEY,
   firstname VARCHAR (50),
   lastname VARCHAR (50),
   email varchar(50)
);



insert into users values (1, 'vins', 'guru', 'admin@vinsguru.com');
insert into users values (2, 'michael', 'jackson', 'michael@vinsguru.com');
insert into users values (3, 'slim', 'shady', 'shady@vinsguru.com');


select * from users;

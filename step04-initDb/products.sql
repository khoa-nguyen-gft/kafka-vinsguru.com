CREATE TABLE product(
   id serial PRIMARY KEY,
   description VARCHAR (500),
   price numeric (10,2) NOT NULL,
   qty_available integer NOT NULL
);

insert into product values (1, 'ipad', 300, 10);
insert into product values (2, 'iphone', 650, 98);
insert into product values (3, 'tv', 320, 560);

select * from product;
drop table receipt if exists;
create table receipt (
  id int primary key,
  productName varchar(30) not null
);
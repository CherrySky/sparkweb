drop table receipt if exists;
create table receipt (
  id int primary key,
  productName varchar(50) not null,
  currency varchar(3) not null,
  price numeric not null,
  purchaseDate date not null,
  warrantyDate date not null,
  category varchar(20),
  shopName varchar(50),
  shopInvoice varchar(50),
  shopAddress varchar(50),
  shopPhone varchar(50),
  remarks varchar(50)
);

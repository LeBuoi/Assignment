CREATE DATABASE Assignment

Create table tblUsers(userID char(8) PRIMARY KEY NOT NULL,
fullName nvarchar(50) not null, roleID nchar(20) not null, password nchar(20) not null)

Create table Category(CategoryID char(8) PRIMARY KEY NOT NULL, 
CategoryName nvarchar(50) not null)

Create table tblProducts(ProductID char(8) PRIMARY KEY NOT NULL, 
Name nvarchar(50) not null, Quantity int not null, price float not null, CategoryID char(8) foreign key references Category(CategoryID))

Create table OrderDetails(OrderID nchar(8) Primary Key not null,
UserID char(8) not null, date time, total int not null, status char(8) not null, 
ProductID char (8) foreign key references tblProducts(ProductID))

Create table OrderProducts(OrderProductID nchar(8) primary key not null, 
OrderID nchar(8) foreign key references OrderDetails(OrderID), 
ProductID char(8) foreign key references tblProducts(ProductID),
Price float not null, Quantity int not null)

alter table OrderDetails
drop column UserID 

alter table OrderDetails
add userID char(8) foreign key references tblUsers(userID)

alter table tblProducts
alter column Price float not null

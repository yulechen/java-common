Create table If Not Exists Customers (Id int, Name varchar(255));
Create table If Not Exists Orders (Id int, CustomerId int);
Truncate table Customers;
insert into Customers (Id, Name) values ('1', 'Joe');
insert into Customers (Id, Name) values ('2', 'Henry');
insert into Customers (Id, Name) values ('3', 'Sam');
insert into Customers (Id, Name) values ('4', 'Max');
Truncate table Orders;
insert into Orders (Id, CustomerId) values ('1', '3');
insert into Orders (Id, CustomerId) values ('2', '1');

--  480 ms 从不下订单的客户
SELECT c.`Name` as Customers FROM Customers C LEFT JOIN  Orders O
ON C.ID=O.CustomerId WHERE O.CustomerId IS null;

--  566 ms 从不下订单的客户
select c.`Name` as Customers from Customers c where c.id not in (select CustomerId from Orders );
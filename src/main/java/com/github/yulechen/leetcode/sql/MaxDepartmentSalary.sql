
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');

-- 找出每个部门员工工资最高
select a.name Department ,b.name Employee ,a.salary Salary  FROM Employee  b join
(select d.name `name`, d.id DepartmentId,max(e.salary) salary from Employee  e join Department d  on e.DepartmentId=d.id  GROUP BY e.DepartmentId ) a
on b.DepartmentId= a.DepartmentId and b.salary=a.salary;

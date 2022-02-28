--create table employees (id bigint not null, job varchar(255), name varchar(255) not null, salary integer, primary key (id));
--test data
insert into employees (id,name,job,salary)values(1,'Dexter','boss', 4000);
insert into employees (id,name,job,salary)values(2,'Nyme','manager', 3000);
insert into employees (id,name,job,salary)values(3,'Cooks','boss', 4000);
insert into employees (id,name,job,salary)values(4,'Elmo','intern', 1000);
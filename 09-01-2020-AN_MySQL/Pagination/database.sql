create database employees;
use employees;
create table Student (
    id integer primary key,
    firstNm varchar(30),
    lastNm varchar(30)
);


insert into Student values(1,'Rohit','Gonsalves'); 

insert into Student values(2, 'Darshan', 'Patil');

insert into Student values(3, 'Omkar', 'Patil');

insert into Student values(4,'Sharon','Paul'); 

insert into Student values(5, 'Sangeeta', 'Shenoy');

insert into Student values(6, 'Payal', 'Mantri');

insert into Student values(7, 'Bhaskar', 'Patil');

insert into Student values(8,'Anthony','Gonsalves'); 

insert into Student values(9, 'Darshan', 'Kurup');

insert into Student values(10, 'Omkar', 'Raykar');

select * from Student;

call paginate(2,2);

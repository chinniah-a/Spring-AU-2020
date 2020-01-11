drop database if exists rohit;
create database rohit;
use rohit;
drop table if exists Student;
create table Student (
    id integer primary key,
    firstNm varchar(30),
    lastNm varchar(30)
);

drop table if exists Students_Log;
create table Students_Log (
	actions varchar(10),
    id integer,
    firstNm varchar(30),
    changedate varchar(150)
);

drop trigger if exists before_student_update;
create trigger before_student_update
    before update on Student
    for each row
insert into Students_Log
set actions = 'update',
 	id = old.id,
    firstNm = old.firstNm,
 	changedate = now();





 
 drop trigger if exists before_students_insert;
 DELIMITER $$
create trigger before_students_insert
before insert
on Student for each row
begin
    insert into Students_Log
    set actions = 'insert',
    id = new.id,
    firstNm = new.firstNm,
    changedate = now();
    
end $$
 
DELIMITER ;

DELIMITER $$
 
create trigger before_students_delete
before delete
on Student for each row
begin
    insert into Students_Log
    set actions = 'delete',
    id = old.id,
    firstNm = old.firstNm,
	changedate = now();
end$$    
 
DELIMITER ;


insert into Student values(1,'Rohit','Gonsalves'); 

select * from Students_Log;

update Student set firstNm = 'Darshan' where id = 1;

select * from Students_Log;

delete from Student where id = 1;

select * from Students_Log;
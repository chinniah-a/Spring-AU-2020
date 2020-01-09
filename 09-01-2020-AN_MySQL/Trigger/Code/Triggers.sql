create database rohit;
use rohit;
drop table if exists Student;
create table Student (
    id integer primary key,
    firstNm varchar(30),
    lastNm varchar(30)
);
drop table if exists Students_Audit;
create table Students_Audit (
	actions varchar(10),
    id integer,
    changedate varchar(150)
);

drop trigger if exists before_student_update;
create trigger before_student_update
    before update on Student
    for each row
insert into Students_Audit
set actions = 'update',
 	id = OLD.id,
 	changedate = now();





 
 drop trigger before_students_insert;
 DELIMITER $$
create trigger before_students_insert
before insert
on Student for each row
begin
    insert into Students_Audit
    set actions = 'insert',
    changedate = NOW();
    
end $$
 
DELIMITER ;

DELIMITER $$
 
create trigger before_students_delete
before delete
on Student for each row
begin
    insert into Students_Audit
    set actions = 'delete',
    id = old.id,
	changedate = now();
end$$    
 
DELIMITER ;


insert into Student values(1,'Rohit','Gonsalves'); 

select * from Students_Audit;

update Student set firstNm = 'Darshan' where id = 1;

select * from Students_Audit;

delete from Student where id = 1;

select * from Students_Audit;
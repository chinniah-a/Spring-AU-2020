package database;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;  
public class JavaSQL {
	
	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<Student>();
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test","root","roadrash");  
			//here test is database name, root is username
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("call joinme();");  // Calling Stored procedure
			System.out.println("Id \t\t Name \t\t Branch");
			while(rs.next())  
			list.add(new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)));  // Initialize objects
			con.close();
			
			System.out.print("Data:\n");
			
			for(Student s : list) {
				System.out.println(s.toString());
			}
			}catch(Exception e){ System.out.println(e);}  
			} 
		
	}



// Entity Class
class Student{
	int id,cgpa;
	String name, department, hod;
	
	public Student(int id,String name,int cgpa,String department,String hod) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
		this.department = department;
		this.hod = hod;
	}
	
	
	@Override
	public String toString() {
		return "{ \nId: " + this.id + "\nName: " + this.name + "\nCGPA: " + this.cgpa + "\nDepartment: " + this.department + "\nHOD: " + this.hod + "\n}"; 
	}
}



/*
SQL Queries to setup database
drop database if exists test;
create database test;
use test;

create table Department(Id int(100), department_name varchar(100),primary key(Id));
 insert into department values(1,'Computers');
 insert into department values(2,'Information Technology');
 insert into department values(3,'Electronics and Telecomunications');
 insert into department values(4,'Electronics');
 
 
create table Student(Id int(100) primary key, student_name varchar(100), department_id int(100));

insert into Student values(1,"Rohit Gonsalves",1);
insert into Student values(2,"Rohan Pawar",2);
insert into Student values(3,"Darshan Patil",3);
insert into Student values(4,"Omkar Raykar",4);
insert into Student values(5,"Gaurav Yadav",1);
insert into Student values(6,"Rahul Guhekar",2);
insert into Student values(7,"Preet Dabre",3);
insert into Student values(8,"Raj Chandvaniya",4);
insert into Student values(9,"Abhishek Upamanyu",1);
insert into Student values(10,"Karunesh Talwar",2);


use test;


alter table student add column cgpa int;

update Student set cgpa = 10 where Id % 2 = 0;
update Student set cgpa = 9 where Id % 2 = 1;

SET SQL_SAFE_UPDATES = 0;


select * from student;
alter table department add column hod varchar(100) ;
update department set hod = "Anant Nimkar" where id = 1;
update department set hod = "Dhananjay Kalbande" where id = 2;
update department set hod = "Rohan Pawar" where id = 3;
update department set hod = "Surendra Rathod" where id = 4;

describe student;


USE `test`;
DROP procedure IF EXISTS `joinme`;

DELIMITER $$
USE `test`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `joinme`()
BEGIN
select s.Id, s.student_name,s.cgpa, d.department_name,d.hod from Student as s,Department as d where s.department_id = d.Id;
END$$

DELIMITER ;
*/
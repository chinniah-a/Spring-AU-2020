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
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("call joinme();");  
			System.out.println("Id \t\t Name \t\t Branch");
			while(rs.next())  
			list.add(new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)));  
			con.close();
			
			System.out.print("Data:\n");
			
			for(Student s : list) {
				System.out.println(s.toString());
			}
			}catch(Exception e){ System.out.println(e);}  
			} 
		
	}




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
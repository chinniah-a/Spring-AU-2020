<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Data</title>
    </head>
    <body>
        <div align="center" class="jumbotron-fluid">
            <h1>Employee List</h1>
            <h3><a href="addEmployee">New Employee</a></h3>
            <table border="1">
            	<thead>
	                <th>Emp ID</th>
	                <th>First Name</th>
	                <th>Last Name</th>
	                <th>Contact</th>
	                
	                <th>Action</th>
                </thead>
                 
                <c:forEach var="emp" items="${listEmployees}">
	                <tr>
	                    <td>${emp.id}</td>
	                    <td>${emp.firstName}</td>
	                    <td>${emp.lastName}</td>
	                    <td>${emp.contact}</td>
	                    
	                    <td>
	                        <a href="editEmployee?id=${emp.id}">Edit</a>
	                        &nbsp;&nbsp;&nbsp;&nbsp;
	                        <a href="deleteEmployee?id=${emp.id}">Delete</a>
	                    </td>
	                             
	                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>
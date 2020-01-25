<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Add/Update Employee</title>

<style type="text/css">
body{

	background-color:  gray;
}

.textbox{
	border-radius: 100px;
	border-style: solid;   
	border-color: black;
	padding-left:  20px; 
}

.btn-success{

	border-radius: 5px;
	border-style: solid;   
	border-color: transparent;
	width: 50px;
}

</style>

<script type="text/javascript">
            function validate()
            {
                var a = document.getElementById("firstName").value;
                var b = document.getElementById("lastName").value;
                var c = document.getElementById("contact").value;
                
                var valid = true;
                if(a.length<=0 || b.length<=0 || c.length<=0)
                    {
                        alert("Don't leave the field empty!");
                        valid = false;
                    }
                 
                return valid;
            };
        </script>
</head>
<body>
	<div align="center" class="jumbotron">
        <h1>New/Edit Employee</h1>
        <form:form action="addEmployee" method="post" modelAttribute="employee" onsubmit="return validate();">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName" id="firstName" class="textbox"/></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName" id="lastName" class="textbox"/></td>
            </tr>
            <tr>
                <td>Contact:</td>
                <td><form:input path="contact" id="contact" class="textbox"/></td>
            </tr>
            
                <td colspan="2" align="center"><input type="submit" value="Save" class="btn-success"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>
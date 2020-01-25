<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add/Update Employee</title>

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
	<div align="center">
        <h1>New/Edit Employee</h1>
        <form:form action="addEmployee" method="post" modelAttribute="employee" onsubmit="return validate();">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName" id="firstName"/></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName" id="lastName"/></td>
            </tr>
            <tr>
                <td>Contact:</td>
                <td><form:input path="contact" id="contact"/></td>
            </tr>
            
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>
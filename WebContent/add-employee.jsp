<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Onboarding</title>
</head>
<body>
	<h1>Employee Onboarding</h1>
	<form action="addEmployeeServlet" method="post">
		First Name: <input type="text" name="firstName"><br/>
		Last Name: <input type="text" name="lastName"><br/>
		<input type="submit" value="Add Employee">
	</form><br/>
	<a href="viewEmployeesServlet">Return to Employee Management</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Manage Employees</title>
</head>
<body>
	<h1>Employee Management</h1>
	<form method="post" action="employeeNavigationServlet">
		<table>
			<tr>
				<th>Select</th>
				<th>Last Name</th>
				<th>First Name</th>
			<c:forEach items="${requestScope.allEmployees}" var="currentemployee">
				<tr>
					<td><input type = "radio" name="id" value="${currentemployee.id}"></td>
					<td>${currentemployee.lastName}</td>
					<td>${currentemployee.firstName}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Add" name="doThis">
		<input type="submit" value="Edit" name="doThis">
		<input type="submit" value="Delete" name="doThis">
	</form>
	<br>
	<a href="index.html">Return Home</a>
	<a href="viewEventServlet">View Events</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event Management</title>
</head>
<body>
<h1>Events Planned</h1>
<form method="post" action="eventNavigationServlet">
<table>
<c:forEach items="${requestScope.totalEvents}" var="currentEvents">
<tr>
	<td><input type="radio" name="id" value="${currentEvents.id}"></td>
	<td><h2>${currentEvents.name}</h2></td></tr>
	<tr><td colspan = "10">Event Date: ${currentEvents.getEventDate()}</td></tr>
	<tr><td colspan="10">Employee Host: ${currentEvents.getHost().getFirstName()} ${currentEvents.getHost().getLastName()}</td></tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThis">
<input type = "submit" value = "delete" name="doThis">
<input type="submit" value = "add" name = "doThis">
</form>
<br>
<a href="index.html">Return Home</a>
<a href="viewEmployeesServlet">View Employees</a>
</body>
</html>
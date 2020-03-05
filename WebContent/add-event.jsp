<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Event</title>
</head>
<body>
<h1>Add Event</h1>
<form action = "addEventServlet" method = "post">
Event Name: <input type ="text" name = "Ename"></br /></br />
Event date: <input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">
<br />

host:
<br />
<select name="host" multiple size="6">
<c:forEach items="${requestScope.allEmployees}" var="currentPeople">
	<option value = "${currentPeople.id}">${currentPeople.firstName} ${currentPeople.lastName}</option>
</c:forEach>
</select>
<br />
<br />
<input type="submit" value="Add Event">
</form>
<a href="viewEventServlet">Return to Event Management</a>
</body>
</html>
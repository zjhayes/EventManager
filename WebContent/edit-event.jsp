<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Edit Event</title>
</head>
<body>
<h1>Edit Event</h1>
<form action = "editEventServlet" method="post">
Event Name: <input type ="text" name = "Ename" value="${toEdit.name}"><br />
Event Date: <input type ="text" name = "month" placeholder="mm" size="4" value="${toEdit.getEventDate().getMonthValue()}"> <input type ="text" name = "day" placeholder="dd" size="4" value="${toEdit.getEventDate().getDayOfMonth()}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value="${toEdit.getEventDate().getYear()}">
<input type = "hidden" name = "id" value="${toEdit.id}">
<br />
<br />
Current Host:<br />
	<select name="currentHost" multiple size="6">
		 <option value = "${toEdit.getHost().id}">${toEdit.getHost().firstName} ${toEdit.getHost().lastName}</option>
	</select>
<br />
<br />
Employee Hosts:<br />
<select name="hostToAdd" multiple size="6">
<c:forEach items="${requestScope.PeopleToAdd}" var="currentPerson">
   <option value = "${currentPerson.id}">${currentPerson.firstName} ${currentPerson.lastName}</option>
</c:forEach>
</select>

<br />
<br />
<input type = "submit" value="Save Changes">
</form>
</body>
</html>
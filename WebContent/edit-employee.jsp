<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Edit Employee Details</title>
</head>
<body>
	<h1>Edit Employee</h1>
	<form action="editEmployeeServlet" method="post">
		First Name: <input type="text" name="firstName" value="${toEdit.firstName}"><br/>
		Last Name: 	<input type="text" name="lastName" value="${toEdit.lastName}"><br/>
		<input type="hidden" name="id" value="${toEdit.id}">
		<input type="submit" value="Save Changes">
	</form>
</body>
</html>
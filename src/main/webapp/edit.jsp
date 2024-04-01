<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Uniform</title>
</head>
<body>
	<form action="editUniformServlet" method="post">
		Player Name: <input type="text" name="name" value="${uniToEdit.name }">
		Uniform Number: <input type="text" name="number" value="${uniToEdit.number }">
		<input type="hidden" name="id" value="${uniToEdit.id }">
		<input type="submit" value="Save Edited Uniform">
	</form>
</body>
</html>
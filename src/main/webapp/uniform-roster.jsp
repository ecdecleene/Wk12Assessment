<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uniform Roster</title>
</head>
<body>
	<form method="post" action="navigationServlet">
	<table>
	<c:forEach items="${requestScope.allUniforms }" var="currentuniform">
		<tr>
		<td><input type="radio" name="id" value="${currentuniform.id}"></td>
		<td>${currentuniform.name}</td>
		<td>${currentuniform.number}</td>
		</tr>
	</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToUniform">
	<input type="submit" value="delete" name="doThisToUniform">
	<input type="submit" value="add" name="doThisToUniform">
	</form>
</body>
</html>
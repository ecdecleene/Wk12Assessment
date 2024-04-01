<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Team</title>
</head>
<body>
	<form action="editTeamPlayersServlet" method="post">
	<input type="hidden" name="id" value="${teamToEdit }">
	Team Name: <input type="text" name="teamName" value="${teamToEdit.teamName}"><br />
	Coach Name: <input type="text" name="coachName" value="${teamToEdit.coach.coachName}"><br />
	Available Players:<br />
	
	<select name="allUniformsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allUniforms}" var="currentUniform">
	<option value="${currentUniform.id}">${currentUniform.name} ${currentUniform.number}</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Edit Team">
	</form>
	<a href="index.html">Home</a>
</body>
</html>
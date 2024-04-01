<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teams</title>
</head>
<body>
<form method="post" action="teamNavigationServlet">
<table>
<c:forEach items="${requestScope.allTeams}" var="currentteam">
<tr>
	<td><input type="radio" name="id" value="${currentteam.id}"></td>
	<td><h2>${currentteam.teamName}</h2></td>
</tr>

<tr>
	<td colspan="3">Coach: ${currentteam.coach.coachName}</td>
</tr>
<c:forEach var="listVal" items="${currentteam.teamPlayers}">
<tr><td></td>
<td colspan="3">
${listVal.name}, ${listVal.number}
</td>
</tr>
</c:forEach>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToTeam">
<input type="submit" value="delete" name="doThisToTeam">
<input type="submit" value="add" name="doThisToTeam">

</form>
<a href="addUniformsToTeamServlet">Create New Team</a><br />
<a href="index.html">Home</a>
</body>
</html>
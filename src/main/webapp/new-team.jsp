<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Team</title>

<script>

	function checkForm(form){
		if(form.teamName.value == ""){
			alert("Input is empty");
			form.teamName.focus();
			return false;
		}
		
		if(form.coachName.value == ""){
			alert("Input is empty");
			form.coachName.focus();
			return false;
		}
		
		var regular = /^[\w ]+$/;
		
		if(!regular.test(form.teamName.value)){
			alert("Invalid input")
			form.teamName.focus();
			return false;
		}
		
		if(!regular.test(form.coachName.value)){
			alert("Invalid input")
			form.coachName.focus();
			return false;
		}
		
		return true;
	}

</script>

</head>
<body>
	<form action="createNewTeamServlet" method="post" onsubmit="return checkForm(this)">
	Team Name: <input type="text" name="teamName"><br />
	Coach Name: <input type="text" name="coachName"><br />
	
	Available Players:<br />
	<select name="allUniformsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allUniforms}" var="currentuniform">
	<option value="${currentuniform.id}">${currentuniform.name} ${currentuniform.number}</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value="Create Team">
	</form>
	<a href="index.html">Home</a>
</body>
</html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Client:</title>
</head>
<body>

	<h3>Find Client:</h3>
	<sf:form method="POST" modelAttribute="client">
	First name™: <sf:input path="firstName" /><br />	 
	Last name: <sf:input path="lastName" /><br />
		<input type="submit" value="Find" />

	</sf:form>


</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>

	<h2>Registration succeed for:</h2><br>
	<c:out value="${client.firstName}" />
	<c:out value="${client.lastName}" /><br><br><br>
	
	<a href="<c:url value="/home" />">Back to homePage</a>
	
</body>
</html>
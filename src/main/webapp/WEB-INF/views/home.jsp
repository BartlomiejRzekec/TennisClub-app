<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>homepage</title>
</head>
<body>


	<h1>Welcome to Tennis Club home page</h1>
	<a href="<c:url value="/addTrainers" />">Add Trainers to start</a> |<br /><br />
	<a href="<c:url value="/register" />">Register</a><br />
	<a href="<c:url value="findClient" />">Find Client</a><br />
	<a href="<c:url value="/showAllClients" />">Show list of Clients</a><br />
	<a href="<c:url value="/showAllTrainers" />">Show list of Trainers</a>
	
</body>
</html>
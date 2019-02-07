<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
<title>homepage</title>
</head>
<body>

<%@include file="/WEB-INF/incl/menu.app" %>

	<table width="500" border="0" cellpadding="4" cellspacing="1"
			align="left">
	
		<h1>Welcome to Tennis Club home page</h1>
		
		<tr>
			<td>
				<a href="<c:url value="/addTrainers" />">Click to auto-add trainers to Data Base</a>
			</td>
		</tr> 
		<tr>
			<td>
				<a href="<c:url value="/register" />">Register</a>
			</td>
		</tr> 
		<tr>
			<td>
				<a href="<c:url value="findClient" />">Find Client</a>
			</td>
		</tr> 
		<tr>
			<td>
				<a href="<c:url value="/showAllClients" />">Show list of Clients</a>
			</td>
		</tr> 
		<tr>
			<td>
				<a href="<c:url value="/showAllTrainers" />">Show list of Trainers</a>
			</td>
		</tr> 
	
	
	
	
	</table>>
	
</body>
</html>
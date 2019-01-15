<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>

	<h1>Registration</h1>
	<sf:form method="POST" modelAttribute = "client">
	<sf:errors path="*" element="div" cssClass="error"/><br/>
				First name™: <sf:input path="firstName" /><br/>
				Last name: <sf:input path="lastName" /><br/>
				Chose trainer by last name: Nowak, Kowalski <sf:input path="trainerByLastName" /><br/>
		<input type="submit" value="Register" />
	</sf:form>
</body>
</html>
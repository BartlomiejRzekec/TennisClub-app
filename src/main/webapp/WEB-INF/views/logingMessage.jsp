<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><s:message code="menu.profil"/></title>
</head>
<body>

	<h2><s:message code="user.register.success"/></h2><br>
	<c:out value="${client.firstName}" />
	<c:out value="${client.lastName}" /><br><br><br>
	
	<a href="<c:url value="/home" />"><s:message code="menu.backToHome"/></a>
	
</body>
</html>
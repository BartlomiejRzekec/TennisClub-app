<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
<title><s:message code="menu.mainPage"/></title>
</head>
<body>

<%@include file="/WEB-INF/incl/menu.app" %>

	<table width="500" border="0" cellpadding="4" cellspacing="1"
			align="left">
	
		<h1>Welcome to Tennis Club home page</h1>
		

	<sec:authorize access="! isAuthenticated()">
		<tr>
			<td>
				<a href="<c:url value="/login" />"><s:message code="menu.login"/></a>
			</td>
		</tr> 
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<tr>
			<td>
				<a href="<c:url value="/profile" />"><s:message code="menu.profil"/></a>
			</td>
		</tr> 
	</sec:authorize>
		
		<tr>
			<td>
				<a href="<c:url value="/register" />"><s:message code="menu.register"/></a>
			</td>
		</tr> 		
		<tr>
			<td>
				<a href="<c:url value="/showAllTrainers" />"><s:message code="menu.trainers"/></a>
			</td>
		</tr> 
	
	
	
	
	</table>>
	
</body>
</html>
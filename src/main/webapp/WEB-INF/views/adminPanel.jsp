<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><s:message code = "menu.adminPage"/></title>
</head>
<body>

<h2><s:message code = "menu.adminPanel"/></h2>


	<table>
	
		<tr>
			<td>
				<a href="<c:url value="/showAllClients" />"><s:message code="menu.clients"/></a>
			</td>
		</tr> 
		<tr>
			<td>
				<a href="<c:url value="/findClient" />"><s:message code="menu.findClient"/></a>
			</td>
		<tr>
			<td>
				<a href="<c:url value="/home" />"><s:message code="menu.backToHome"/></a>
			</td>
		</tr> 
	
	</table>

</body>
</html>
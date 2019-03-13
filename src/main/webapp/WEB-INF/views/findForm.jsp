<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><s:message code="menu.findClient"/></title>
</head>
<body>

	<h3><s:message code="menu.findClient"/></h3>
	<sf:form method="POST" modelAttribute="client">

		<table width="400" align="left">
		
				<tr>
					<td> <s:message code="register.firstName"/>: <sf:input path="firstName" /></td>				
				</tr>
				<tr>
					<td> <s:message code="register.lastName"/>: <sf:input path="lastName" /></td>				
				</tr>
				<tr>
					<td> <input type="submit" value="Find" /></td>				
				</tr>
		
		
		</table>		
			
	</sf:form>


</body>
</html>
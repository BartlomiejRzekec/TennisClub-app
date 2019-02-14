<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><s:message code="profil.userData"/></title>
</head>
<body>

	<h2><s:message code="profil.userData"/></h2>


		<table>
		
			<tr>			
				<td width="140" align="left">
					<s:message code="register.firstName"></s:message>
				</td>
				<td width="140" align="right">
					<c:out value="${client.firstName }"></c:out>
				</td>				
			</tr>
			<tr>			
				<td width="140" align="left">
					<s:message code="register.lastName"></s:message>
				</td>
				<td width="140" align="right">
					<c:out value="${client.lastName }"></c:out>
				</td>				
			</tr>
			<tr>			
				<td width="140" align="left">
					<s:message code="register.email"></s:message>
				</td>
				<td width="140" align="right">
					<c:out value="${client.email}"></c:out>
				</td>				
			</tr>
			<tr>			
				<td width="140" align="left">
					<s:message code="profil.role"></s:message>
				</td>
				<td width="140" align="right">
					<c:choose>
						<c:when test="${client.roleNumber == 1 }">
							<s:message code="word.admin"/>
						</c:when>
						<c:otherwise>
							<s:message code="word.user"/>
						</c:otherwise>
					</c:choose>
				</td>				
			</tr>
			<tr>
				<td>
					<a href="<c:url value="/home" />"><s:message code="menu.backToHome"/></a>
				</td>
			</tr> 
		
		</table>

</body>
</html>
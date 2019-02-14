<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" >
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
<title><s:message code="loging.pageName"/></title>
</head>
<body>

	<%@include file="/WEB-INF/incl/menu.app" %>
	
	<h2><s:message code="loging.pageName"/></h2>
	
		<form action="/login" method="POST">
			
			<table width="600" border="0" cellpadding="4" cellspacing="1"
			align="center">
			
				<tr>
					
					<td colspan="2" align="center">
						<c:if test="${not empty param.error}">
							<font color="red"><s:message code="error.logowanie"/></font>
						</c:if>
					</td>
				
				</tr>
			
				<tr>
				
					<td align="right" width="140">
						<s:message code="register.email" />
										
					</td>
					
					<td align="left">
					<input type="text" name="email" id="email"
						size="30" />
					
					</td>
				
				</tr>
				
					<tr>
					
					<td align="right" width="140">
						<s:message code="register.password" />
						
					</td>
					
					<td align="left">
						<input type="password" name="password" id="password" size="30" />
						
					</td>
				
				</tr>
				
				<tr>
					<td colspan="2" align="center" bgcolor="#ffffff"><input
						type="submit" value="Log in"/></td>
						
					<td align="left">
						<input id="remember_me" name="remember-me" type="checkbox"/>
						<label for="remember_me" class="inline"><s:message code="checkbox.rememberMe"></s:message></label>
					</td>	
				</tr>
			
		
			
			</table>
			
			
		
		
		</form>

</body>
</html>
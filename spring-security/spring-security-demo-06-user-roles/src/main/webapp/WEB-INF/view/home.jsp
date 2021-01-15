<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
	<head>
		<title>Spring Security Home Page</title>
	</head>
	
	<body>
		<h2>Welcome to Spring Security Home Page</h2>
		<hr>
		<p>
		This is a demo App describing spring security
		</p>
		<hr>
		<!-- Display user name and role -->
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Role(s): <security:authentication property="principal.authorities"/>
		</p>
		
		
			<security:authorize access="hasRole('MANAGER')">
				<!-- Add a link to point to /leaders and this is for managers -->
				<p>
					<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
					(Only for Manager peeps)
				</p>
			</security:authorize>
			
			<security:authorize access="hasRole('ADMIN')">
				<!-- Add a link to point to /systems and this is for admins -->
				<p>
					<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
					(Only for Admin peeps)
				</p>
			</security:authorize>
			
		<hr>
		
		<!-- adding a logout button -->
		<form:form method="POST" action="${pageContext.request.contextPath}/logout">
			<input type="submit" value="Logout"/>
		</form:form>
	</body>
</html>
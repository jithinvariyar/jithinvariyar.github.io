<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<!-- adding a logout button -->
		<form:form method="POST" action="${pageContext.request.contextPath}/logout">
			<input type="submit" value="Logout"/>
		</form:form>
	</body>
</html>
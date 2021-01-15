<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Leaders Home Page</title>
	</head>
	
	<body>
		<h2>Spring Security Leaders Home Page</h2>
		<hr>
		<p>
			This is a secret info, only provided to Managers!
			<br>
			Don't available to regular employees or Admins
		</p>
		<hr>
		<a href="${pageContext.request.contextPath}/">Back To Home Page</a>
	</body>
</html>
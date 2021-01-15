<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Systems Home Page</title>
	</head>
	
	<body>
		<h2>Spring Security Systems Home Page</h2>
		<hr>
		<p>
			This is a secret info, only provided to Admins!
			<br>
			Don't available to regular employees or Managers
		</p>
		<hr>
		<a href="${pageContext.request.contextPath}/">Back To Home Page</a>
	</body>
</html>
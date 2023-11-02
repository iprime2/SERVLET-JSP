<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/college/logout">
		<h4>Hi ${username}, Login Successful</h4>
		<h4>Your Session ID = ${sessionId}</h4>
		<button type="submit">Logout</button>
	</form>

</body>
</html>
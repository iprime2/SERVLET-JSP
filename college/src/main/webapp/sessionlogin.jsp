<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Account</h1>

	<p>${error}</p>
	<form method="post" action="/college/sessionlogin">
		<div>
			<label for="username">Username: </label>
			<input type="text" id="username" name="username"></input>
		</div>
		<div>
			<label for="password">Password</label>
			<input type="password" id="password" name="password"></input>
		</div>

		<button type="submit">Login</button>
	</form>
</body>
</html>
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

	<form method="post" action="/college/login">
		<div>
			<label for="email">E-mail</label>
			<input type="email" id="email" name="email"></input>
		</div>
		<div>
			<label for="password">Password</label>
			<input type="password" id="password" name="password"></input>
		</div>

		<button type="submit">Login</button>
	</form>
</body>
</html>
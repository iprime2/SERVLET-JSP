<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>
	<h1>Register Account</h1>

	<form method="post" action="/Learning/register">
		<div>
			<label for="email">E-mail</label>
			<input type="email" id="email" name="email"></input>
		</div>
		<div>
			<label for="name">Name</label>
			<input type="text" id="name" name="name"></input>
		</div>
		<div>
			<label for="age">Age</label>
			<input type="number" id="age" name="age"></input>
		</div>
		<div>
			<label for="password">Password</label>
			<input type="password" id="password" name="password"></input>
		</div>
		<div>
			<label for="confirmPassword">Confirm Password</label>
			<input type="password" id="confirmPassword" name="confirmPassword"></input>
		</div>
		
		<button type="submit">Create Account</button>
	</form>
	<p>${error}</p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Two Number</h1>
	<hr />
	<form method="post" action="/college/sum">
		<div>
			<label for="num1">Enter First Number:</label>
			<input type="number" id="num1" name="num1"></input>
		</div>
		<br />
		
		<div>
			<label for="num2">Enter Second Number:</label>
			<input type="number" id="num2" name="num2"></input>
		</div>
		<br />
		<button type="submit">Add</button>
	</form>
	
	<br />
	
	<p>${error}</p>
	<p>${sum}</p>
<hr />
</body>
</html>
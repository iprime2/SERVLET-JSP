<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register</h1>
    <form method="post" action="/college/RegisterCookieServlet">
    	Name:
        <input type="text" name="name"> <br>
        Age:
        <input type="text" name="age"><br>
        Phone:
        <input type="text" name="phone"> <br>
        Email:
        <input type="text" name="email"> <br>
        <br>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
</body>
</html>
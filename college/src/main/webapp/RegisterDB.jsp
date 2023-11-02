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
    <form method="post" action="/college/RegisterDbServlet">
    	Name:
        <input type="text" name="name"> <br>
        Password:
        <input type="password" name="password"><br>
        Mobile No.:
        <input type="text" name="mobile"> <br>
        Email id:
        <input type="text" name="email"> <br>
        <br>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
</body>
</html>
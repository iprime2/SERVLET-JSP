<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ques 5</title>
</head>
<body>
	<form action="/college/BookCRUDServlet" method="post">
        <input type="hidden" name="action" value="add">
        Name: <input type="text" name="name"><br>
        Password: <input type="password" name="password"><br>
        Gender: <input type="text" name="gender"><br>
        Age: <input type="text" name="age"><br>
        Age: <input type="text" name="age"><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
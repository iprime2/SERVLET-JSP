<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subject</title>
</head>
<body>
	<h1>Select Subject</h1>
    <form method="post" action="/college/Subject">
        <input type="radio" name="subject" value="Python"> Python<br>
        <input type="radio" name="subject" value="Nosql"> NoSql<br>
        <input type="radio" name="subject" value="React"> React<br>
        <input type="radio" name="subject" value="Node"> Node<br>
        <br>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
    
    <h1>Selected Cookie: ${subjectCookie}</h1>
</body>
</html>
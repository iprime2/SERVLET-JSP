<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Creating session</h2>
	
	Session ID: <%= session.getId() %>
	Session created Id: <%= new Date(session.getCreationTime()) %>
</body>
</html>
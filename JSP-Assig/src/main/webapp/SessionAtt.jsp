<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="javax.servlet.http.HttpSession" %>
<%
	HttpSession session3 = request.getSession();
	session.setAttribute("isLogged", false); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Setting Session Attribute</h2>
    <p>Session attribute "exampleAttribute" set to false.</p>
</body>
</html>
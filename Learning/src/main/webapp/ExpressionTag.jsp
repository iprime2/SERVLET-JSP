<%@page import="com.learning.utils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<title>Expression tags</title>
</head>
<body class=" bg-sky-400">

<%@ include file="Navbar.jsp"  %>
<div class="p-5">
<h1>Hello</h1>
<h2>Expression Tags</h2>

<p>Calling a method : <%= Math.addExact(5, 9) %> </p>
<p>Evaluating a boolean: <%= "bob".length() > 3 %></p>
<p>Math Expression: <%= (500.6 * 7) - 60  %> </p>

<%-- This how you make JSP comment --%>
<h2> JSP Scriptlet</h2>
<%
	double myTestScore = 100.0;
	myTestScore = myTestScore - 30.5;
%>
<p>Test score : <%= myTestScore %></p>

<%	if( 1 + 2 == 2){ %>
		<p>One plus one is two</p>
	<% }else{ %>
		<p>Not equal</p>		
	<% } %>
	
<h2> JSP Declaration</h2>	

<%!
	int add(int n1, int n2){
	return n1 + n2;
	}
	
%>

<h3> Addition of 10 + 5 : <%= add(10,5) %></h3>

<h2> JSP Directive Tags</h2>

<h3><%= utils.kaboom() %></h3>
</div>
</body>
</html>
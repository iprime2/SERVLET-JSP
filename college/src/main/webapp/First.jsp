<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.time.Month" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% out.println("Hello first jsp page"); %>

<% 
int n1 = 10;
int n2 = 20;
out.println("No 1 : " + n1);

int sum = n1 + n2;
%> 
	
	<hr>
	<%
	out.println("sum : " + sum);
	%>
	<hr>
	
	<%
		for(Month month: Month.values()){
			out.println(month);
			%>
			<br>
			<%
		}
	%>
	
	
	<%!
		int cube(int n){
		return n * n * n;
		}
	%>
	
	<%="Cube of the no is : " + cube(3) %>
</body>
</html>
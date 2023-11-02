<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Integer count = (Integer)application.getAttribute("hits");
	if(count == null || count == 0){
		count = 1;
	}else {
		count++;
	}
	application.setAttribute("hits", count);
	%>
	
	<p>No of hits are <%= count %></p>
	
</body>
</html>
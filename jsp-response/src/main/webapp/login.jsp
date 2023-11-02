<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/jsp-response/login.jsp">
		Name:<input type="text" name="name"> <br>
		Password:<input type="text" name="password"> <br>
		<button type="submit">Login</button>
	</form>
	
	<%
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if(password != null){
			if(password.equals("123")){
				application.setAttribute("userName", name);
				response.sendRedirect("valid.jsp");
			}else{
				response.sendRedirect("invalid.jsp");
			}
		}
	%>
</body>
</html>
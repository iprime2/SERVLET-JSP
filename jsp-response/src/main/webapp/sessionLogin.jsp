<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/jsp-response/sessionLogin.jsp">
		Name:<input type="text" name="name"> <br>
		Password:<input type="text" name="password"> <br>
		<button type="submit">Login</button>
	</form>
	
	<%
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if(password != null){
			if(password.equals("123")){
				session.setAttribute("userName", name);
				response.sendRedirect("sessionLoginWelcome.jsp");
			}else{
				out.println("Invalid paswword");
				response.sendRedirect("sessionLogin.jsp");
			}
		}
	%>
</body>
</html>
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
	
		Cookie cookie1 = new Cookie("username","athravajoshi");
		response.addCookie(cookie1);
        
        Cookie[] cookies = request.getCookies();

       
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();

                out.println("<p>" + cookieName + " : " + cookieValue + "</p>");
            }
        } else {
            out.println("<p>No cookies found.</p>");
        }
    %>
</body>
</html>
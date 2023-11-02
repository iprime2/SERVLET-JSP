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
        // Printing string values using the out object
        String name = "Sushil Gupta";
        out.println("Hello, " + name + "!<br>");

        // Printing numeric values using the out object
        int age = 23;
        out.println("Your age is: " + age + "<br>");

        // Printing a message using the out object
        out.println("<h2>This is a sample message from p h2 tag</h2>");
    %>
</body>
</html>
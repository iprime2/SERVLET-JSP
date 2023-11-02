<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<h2>Form Data Retrieval</h2>
	    <%-- Retrieve form data using request object --%>
    <% String firstName = request.getParameter("firstName"); %>
    <% String lastName = request.getParameter("lastName"); %>
    
    <form action="/JSP-Assig/Form.jsp" method="post">
        First Name: <input type="text" name="firstName" value=<%= firstName %>><br>
        Last Name: <input type="text" name="lastName" value=<%= lastName %>><br>
        <input type="submit" value="Submit">
    </form>
    


	<p><%= "hello World" %></p>
    <%-- Display the retrieved data --%>
    <p>First Name: <%= firstName %></p>
    <p>Last Name: <%= lastName %></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Customer</title>
</head>
<body>
    <h1>Add Customer</h1>
    
    <%
        String customerName = request.getParameter("customerName");
        String customerEmail = request.getParameter("customerEmail");

        try {
        	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(jdbcDriver);
            String jdbcURL = "jdbc:mysql://localhost:3306/userregister?useSSL=false";
        	String jdbcUsername = "root";
        	String jdbcPassword = "sushil0722";
            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            
            String sql = "INSERT INTO customers (name, email) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerName);
            stmt.setString(2, customerEmail);
            stmt.executeUpdate();

            stmt.close();
            conn.close();

            out.println("<p>Customer added successfully!</p>");
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    %>
    
    <a href="index.jsp">Go back to home</a>
</body>
</html>

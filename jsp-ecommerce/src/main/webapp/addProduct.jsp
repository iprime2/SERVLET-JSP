<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <h1>Add Product</h1>
    
    <%
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));

        try {
        	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(jdbcDriver);
            String jdbcURL = "jdbc:mysql://localhost:3306/userregister?useSSL=false";
        	String jdbcUsername = "root";
        	String jdbcPassword = "sushil0722";
            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, productName);
            stmt.setDouble(2, productPrice);
            stmt.executeUpdate();

            stmt.close();
            conn.close();

            out.println("<p>Product added successfully!</p>");
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    %>
    
    <a href="index.jsp">Go back to home</a>
</body>
</html>

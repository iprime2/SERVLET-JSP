<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>E-Commerce Web Application</title>
    <style>
        /* CSS for table */
        table {
            border-collapse: collapse;
            width: 100%;
        }
        
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        
        /* CSS for form */
        form {
            margin-bottom: 20px;
        }
        
        label {
            display: block;
            margin-bottom: 5px;
        }
        
        input[type="text"],
        input[type="number"],
        input[type="email"],
        input[type="submit"] {
            margin-bottom: 10px;
            padding: 5px;
            width: 200px;
        }
        
        /* CSS for navbar */
        .navbar {
            background-color: #333;
            overflow: hidden;
        }
        
        .navbar a {
            float: left;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        
        .active {
            background-color: #4CAF50;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a class="active" href="#">Home</a>
        <a href="#">Products</a>
        <a href="#">Customers</a>
    </div>
    
    
    <h1>Product Management</h1>
    
    <form method="post" action="addProduct.jsp">
        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName" required><br><br>
        
        <label for="productPrice">Product Price:</label>
        <input type="number" id="productPrice" name="productPrice" required><br><br>
        
        <input type="submit" value="Add Product">
    </form>
    
    <h1>Customer Management</h1>
    
    <form method="post" action="addCustomer.jsp">
        <label for="customerName">Customer Name:</label>
        <input type="text" id="customerName" name="customerName" required><br><br>
        
        <label for="customerEmail">Customer Email:</label>
        <input type="email" id="customerEmail" name="customerEmail" required><br><br>
        
        <input type="submit" value="Add Customer">
    </form>
    
    <h1>Product List</h1>
    <%
        try {
        	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(jdbcDriver);
            String jdbcURL = "jdbc:mysql://localhost:3306/userregister?useSSL=false";
        	String jdbcUsername = "root";
        	String jdbcPassword = "sushil0722";
            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            String sql = "SELECT * FROM products";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            out.println("<table>");
            out.println("<tr><th>Product Name</th><th>Product Price</th></tr>");
            while (rs.next()) {
                String productName = rs.getString("name");
                double productPrice = rs.getDouble("price");
                out.println("<tr><td>" + productName + "</td><td> ₹ " + productPrice + "</td></tr>");
            }
            out.println("</table>");
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    %>
    
    <h1>Customer List</h1>
    <%
        try {
        	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(jdbcDriver);
            String jdbcURL = "jdbc:mysql://localhost:3306/userregister?useSSL=false";
        	String jdbcUsername = "root";
        	String jdbcPassword = "sushil0722";
            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            String sql = "SELECT * FROM customers";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            out.println("<table>");
            out.println("<tr><th>Customer Name</th><th>Customer Email</th></tr>");
            while (rs.next()) {
                String customerName = rs.getString("name");
                String customerEmail = rs.getString("email");
                out.println("<tr><td>" + customerName + "</td><td>" + customerEmail + "</td></tr>");
            }
            out.println("</table>");
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    %>
</body>
</html>





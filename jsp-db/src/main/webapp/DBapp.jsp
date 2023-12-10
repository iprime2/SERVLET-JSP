<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/jsp-db/DBapp.jsp" method="post">
        Email: <input type="text" name="email"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
	
	
	<%
	response.setContentType("text/html");
	
	String jdbcURL = "jdbc:mysql://localhost:3306/userregister?useSSL=false";
	String jdbcUsername = "root";
	String jdbcPassword = "sushil0722";
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";

    String email = request.getParameter("email");
    String password = request.getParameter("password");
    Boolean error = false;

    try {
    	Class.forName(jdbcDriver);
		Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
        
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
        	out.println("<h3>Name:</h3>" + resultSet.getString("name"));
        	out.println("<h3>Email:</h3>" +  resultSet.getString("email"));
        	out.println("<h3>Mobile:</h3>" + resultSet.getString("mobile"));
        } else {
        	error=true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
    
    if(error){
		out.println("<h1>Invalid username or password.</h1>");
	} 
    
	%>
	
	
</body>
</html>
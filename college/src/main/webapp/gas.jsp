<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gas Booking</title>
</head>
<body>
	<h2>Gas Booking Form</h2>
    <form action="/college/gas" method="post">
        Name: <input type="text" name="name"><br>
        Phone: <input type="text" name="phone"><br>
        Address: <input type="text" name="address"><br>
        Qty: <input type="text" name="qty"><br>
        <input type="submit" value="Book Gas">
    </form>
    
    <h1>Error: ${error}</h1>
</body>
</html>
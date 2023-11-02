<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cyber BookStore</h1>
	<br>
    <form action="/college/Book" method="post">
        <label for="subject">Choose a subject:</label>
        <select id="subject" name="subject">
            <option value="operating_system">Operating Systems</option>
            <option value="network_security">Network Security</option>
            <option value="advanced_java">Advanced Java</option>
            <option value="data_mining">Data Mining</option>
        </select>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
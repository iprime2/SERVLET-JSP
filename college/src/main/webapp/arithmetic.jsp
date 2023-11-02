<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Arithmetic Operations</title>
</head>
<body>
	<h2>Arithmetic Operations</h2>
    <form action="arithmetic" method="post">
        Number 1: <input type="text" name="number1"><br>
        Number 2: <input type="text" name="number2"><br>
        Operator:  <select name="operator">
                  <option value="+">Addition</option>
                  <option value="-">Subtraction</option>
                  <option value="*">Multiplication</option>
                  <option value="/">Division</option>
               </select><br>
        <input type="submit" value="Submit">
    </form>


    <h1>Results</h1>
    <h3>${result}</h3>
   	
    <p>${error}</p>
</body>
</html>
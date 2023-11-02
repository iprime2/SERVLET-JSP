<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<title>Insert title here</title>
</head>
<body class="m-0 p-0 h-[100%]">
<div class="p-5">
<h1 class="text-5xl">Example of Attribute</h1>
<hr class="mt-3">
<p class="p-3 bg-red-400 mt-2">${error}</p>

<p class="text-md lg:text-xl p-2 bg-sky-400 mt-2">Hey ${person.firstName} ${person.lastName} , Welcome to JSP</p>
<p>Your age is ${person.age}</p>
</div>
</body>
</html>
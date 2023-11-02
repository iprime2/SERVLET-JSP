<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<title>Registration</title>
</head>
<body>
<body class="flex flex-col item-center">
	<h1 class="mx-auto mt-5 font-bold text-2xl">Register Form</h1>
	<hr class="mt-2"/>
	<div class="p-10 flex flex-col gap-5 rounded-lg">
	<% Object successObj = request.getAttribute("success");  %>
	<% if(successObj != null){ %>
	<p class="p-3 bg-green-500/50">${success}</p>
	<% } %>
	<form method="post" action="/college/register" class="flex flex-col gap-3">
		<div class="flex item-center justify-between w-[350px]">
			<label for="firstName">First Name</label>
			<input class="px-1 border-2 border-slate-300 rounded-md" type="text" id="firstName" name="firstName" value="${firstName}" required></input>
		</div>
		<div class="flex item-center justify-between w-[350px]">
			<label for="middleName">Middle Name</label>
			<input class="px-1 border-2 border-slate-300 rounded-md" type="text" id="middleName" name="middleName" value="${middleName}" required></input>
		</div>
		<div class="flex item-center justify-between w-[350px]">
			<label for="lastName">Last Name</label>
			<input class="px-1 border-2 border-slate-300 rounded-md" type="text" id="lastName" name="lastName" value="${lastName}" required></input>
		</div>
		<div class="flex item-center justify-between w-[350px]">
			<label for="password">Password</label>
			<input class="px-1 border-2 border-slate-300 rounded-md" type="password" id="password" name="password" value="${password}" required></input>
		</div>
		<div class="flex item-center justify-between w-[350px]">
			<label for="confirmPassword">Confirm Password</label>
			<input class="px-1 border-2 border-slate-300 rounded-md" type="password" id="confirmPassword" name="confirmPassword" value="${confirmPassword}" required></input>
		</div>
		<div class="flex item-center justify-between w-[350px]">
			<label for="desiredLogin">Desired Login</label>
			<input class="px-1 border-2 border-slate-300 rounded-md" type="text" id="desiredLogin" name="desiredLogin" value="${desiredLogin}" required></input>
		</div>
		<div class="flex item-center justify-between w-[350px]">
			<label for="location">Location</label>
			<input class="px-1 border-2 border-slate-300 rounded-md" type="text" id="location" name=location value="${location}" required></input>
		</div>
		<div class="flex item-center justify-between w-[350px]">
			<label for="education">Education</label>
			<input class="px-1 border-2 border-slate-300 rounded-md" type="text" id="education" name="education" value="${education}" required></input>
		</div>
		<div class="flex item-center justify-between w-[350px]">
			<label for="phoneNumber">Phone Number</label>
			<input class="px-1 border-2 border-slate-300 rounded-md" type="number" id="phoneNumber" name="phoneNumber" value="${phoneNumber}" required></input>
		</div>
		
		
		<button type="submit" class="border-2 border-slate-200 p-2 rounded-md w-full mt-2 hover:bg-red-300/20">Register</button>
	</form>
	<% Object errorObj = request.getAttribute("error");  %>
	<% if(errorObj != null){ %>
	<p class="p-3 bg-red-300 text-white">${error}</p>
	<% } %>
	</div>
	
</body>
</html>
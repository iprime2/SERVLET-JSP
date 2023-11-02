<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<title>Compound Interest Calculator</title>
</head>
<body class="m-0 p-0 bg-purple-500">
<div class="p-8 mx-auto my-[50px] rounded-lg w-[500px] bg-sky-500 flex flex-col gap-4">
	<h2 class="text-2xl text-center font-bold">Compound Interest Calculator</h2>
	<p class="w-full bg-red-500 font-white text-lg rounded-md text-white">${error}</p>
	<form method="post" action="/CompoundInterest/" class="flex flex-col gap-3">
		<div class="flex flex justify-between">
			<label for="principal-amount" class="text-md font-semibold">Principal Amount:</label>
			<input class="w-[200px] rouned-md p-[2px] focus:outline-none" id="principal-amount" type="number" name="principalamount" value="${principal}">
		</div>
		
		<div class="flex justify-between">
			<label for="interest" class="text-md font-semibold">Interest Percentage:</label>
			<input class="w-[200px] rouned-md p-[2px] focus:outline-none" id="interest" type="number" min="1" max="100" name="interestPercentage" value="${interestPercentage}">
		</div>
		
		<div class="flex justify-between">
			<label for="years" class="text-md font-semibold">No of Years:</label>
			<input class="w-[200px] rouned-md p-[2px] focus:outline-none" id="years" type="number" min="1" name="years" value="${years}">
		</div>
		
		<div class="flex justify-between">
			<label for="compoundingPeriod" class="text-md font-semibold">Times per year:</label>
			<input class="w-[200px] rouned-md p-[2px] focus:outline-none" id="compoundingperiod" type="number" min="1" max="12" name="compoundingPeriod" value="${compoundingPeriod}">
		</div>
		
		<button type="submit" class="w-full bg-cyan-700 p-2 rounded-md text-md hover:bg-cyan-950 text-white">Calculate</button>
	</form>
	<p class="p-4 bg-slate-500 rounded-md text-white">Result : ${result}</p>
</div>
</body>
</html>
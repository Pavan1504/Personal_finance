<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap"
	rel="stylesheet">
<title>Home Page</title>
<link rel="icon" href="favicon.png" type="image/x-icon">
<style media="screen">
*, *:before, *:after {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

body {
	background-color: #080710;
	display: flex;
	justify-content: flex-start;
}

.background {
	width: 430px;
	height: 570px;
	position: absolute;
	transform: translate(-50%, -50%);
	left: 50%;
	top: 50%;
}

form {
	height: 570px;
	width: 400px;
	background-color: rgba(255, 255, 255, 0.13);
	position: absolute;
	transform: translate(-50%, -50%);
	top: 50%;
	left: 50%;
	border-radius: 10px;
	backdrop-filter: blur(10px);
	border: 2px solid rgba(255, 255, 255, 0.1);
	box-shadow: 0 0 40px rgba(8, 7, 16, 0.6);
	padding: 50px 35px;
}

form * {
	font-family: 'Poppins', sans-serif;
	color: #ffffff;
	letter-spacing: 0.5px;
	outline: none;
	border: none;
}

form h3 {
	font-size: 32px;
	font-weight: 500;
	line-height: 42px;
	text-align: center;
}

label {
	display: block;
	margin-top: 30px;
	font-size: 16px;
	font-weight: 500;
}

input {
	display: block;
	height: 50px;
	width: 100%;
	background-color: rgba(255, 255, 255, 0.07);
	border-radius: 3px;
	padding: 0 10px;
	margin-top: 8px;
	font-size: 14px;
	font-weight: 300;
}

::placeholder {
	color: #e5e5e5;
}

button {
	margin-top: 50px;
	width: 100%;
	background-color: #ffffff;
	color: #080710;
	padding: 15px 0;
	font-size: 18px;
	font-weight: 600;
	border-radius: 5px;
	cursor: pointer;
}

.register {
	margin: 10px 0px;
}

.income_sheet, .expense_sheet {
	position: relative;
	width: 400px; /* Adjust width as needed */
	height: 570px; /* Adjust height as needed */
	background-color: rgba(255, 255, 255, 0.13);
	border-radius: 10px;
	backdrop-filter: blur(10px);
	border: 2px solid rgba(255, 255, 255, 0.1);
	box-shadow: 0 0 40px rgba(8, 7, 16, 0.6);
	padding: 50px 35px;
	margin: 0 20px; /* Adjust horizontal margin as needed */
}

.income_sheet {
	margin-right: 500px;
	top: 200px;
	left: 350px; /* Adjust left position as needed */
}

.expense_sheet {
	margin-left: 500px;
	top: 200px;
	right: 350px; /* Adjust right position as needed */
}

.income_sheet form:hover {
	border: 8px solid green;
}

.expense_sheet form:hover {
	border: 8px solid red;
}

header {
	width: 100%;
	color: #fff; /* Text color */
	padding: 20px 0; /* Padding top and bottom */
	text-align: center; /* Center-align content */
	position: fixed; /* Fixed position at the top */
	top: 0;
	z-index: 1000; /* Ensure header stays on top of other content */
	display: flex; /* Use flexbox for layout */
	justify-content: space-between; /* Align items with space between */
	align-items: center; /* Center vertically */
}

header h1 {
	font-family: 'Poppins', sans-serif;
	margin-bottom: 5px; /* Space below h1 */
	margin-left: 20px;
}

header h3 {
	font-family: 'Poppins', sans-serif;
	font-weight: normal; /* Normal font weight */
	margin-right: 20px;
}


header .logout {
	font-family: 'Poppins', sans-serif;
	font-size: 20px;
	margin-right: 20px;
	text-decoration: none;
	color: white;
}
.link {
    display: block;
    width: 100%;
    background-color: #ffffff;
    color: #080710;
    padding: 15px 0;
    font-size: 18px;
    font-weight: 600;
    border-radius: 5px;
    cursor: pointer;
    text-align: center;
    text-decoration: none;
    margin-top: 20px; /* Adjust margin as needed */
}

.balance::placeholder{

	color : black;
}


</style>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("Login.jsp");
		}
	%>



	<header class="head">
		<h1 class="title">Hello! : ${username}</h1>
		<a href="Logout" method="post" class="logout">logout</a>
	</header>
	<div class="income_sheet">

		<form action="income" method="post">
			<h3>Add Your Income</h3>

			<label for="income name">Name or Source</label> <input type="text"
				placeholder="Name or Source" name="income_name"> <label
				for="password">Value</label> <input type="number"
				placeholder="Value" name="income_value">
			<button type="submit">Add income</button>
			<a href="incomeDisplay" class = "link">All your incomes</a>
		</form>
		

	</div>
	<div class="expense_sheet">

		<form action="expense" method="post">
			<h3>Add Your Expense</h3>

			<label for="expense">Expense name</label> <input type="text"
				placeholder="Expense" name="expense_name"> <label
				for="expense_cost">Cost</label> <input type="number"
				placeholder="cost" name="cost">
			<button type="submit">Add expense</button>
			<a href="expenceDisplay" class = "link">All your expenses</a>

		</form>

	</div>
</body>
</html>
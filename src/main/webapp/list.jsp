<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.server.DAO" %>
<%@ page  import = "java.util.List" %>
<%@ page  import = "java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Income Data</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
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
    <h2>${name} Data</h2>
    <table>
        <thead>
            <tr>
                <th>${name} From</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <% 
            ArrayList<DAO> incomeList = (ArrayList<DAO>) request.getAttribute("list");
            for (DAO income : incomeList) {
            %>
            <tr>
                <td><%= income.getType() %></td>
                <td><%= income.getAmount() %></td>
            </tr>
            <% } %>
            <tr style = "border : 3px solid black; color : red; font-weight : bold;
            font-size : 20px;">
            	<td >
            	
            		Net ${name}
            	
            	</td>
            	<td>
            		${total}
            	</td>
            
            
            </tr>
        </tbody>
    </table>
    
</body>
</html>

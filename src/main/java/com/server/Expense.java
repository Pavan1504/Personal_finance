package com.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/expense")
public class Expense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String sql = "insert into expence (expence_name,amount,username) values(?,?,?)";
		String url = "jdbc:mysql://localhost:3306/personal_finance";
		String user_name = "root";
		String dpassword = "Pavan@999";
		String expense_name = request.getParameter("expense_name");
		String username = (String) session.getAttribute("username");
		int amount = Integer.parseInt(request.getParameter("cost"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user_name,dpassword);
			PreparedStatement smt = con.prepareStatement(sql);
			smt.setString(1, expense_name);
			smt.setLong(2, amount);
			smt.setString(3, username);
			int i = smt.executeUpdate();
			System.out.println(expense_name+ " : " + amount + " , " + i + " rows affected");
			con.close();
			session.setAttribute("username", username);
			response.sendRedirect("Home.jsp");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

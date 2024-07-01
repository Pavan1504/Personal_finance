package com.server;

import jakarta.servlet.RequestDispatcher;
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
import java.sql.ResultSet;

@WebServlet("/income")
public class Income extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String sql = "insert into income (income_from,amount,username) values(?,?,?)";
		//String sql2 = "select sum(amount) as total_income from income;";
		String url = "jdbc:mysql://localhost:3306/personal_finance";
		String user_name = "root";
		String dpassword = "Pavan@999";
		String source = request.getParameter("income_name");
		String username = (String) session.getAttribute("username");
		int amount = Integer.parseInt( request.getParameter("income_value"));
		System.out.print(username);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user_name,dpassword);
			PreparedStatement smt = con.prepareStatement(sql);
			smt.setString(1, source);
			smt.setLong(2, amount);
			smt.setString(3, username);
			int i = smt.executeUpdate();
			System.out.println(source + " : " + amount + " , "+ i + " " + "rows affected");
			session.setAttribute("username", username);
			response.sendRedirect("Home.jsp");
			
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}

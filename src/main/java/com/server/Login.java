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

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String sql = "select username,password from login_credentials where username = ?";
		String url = "jdbc:mysql://localhost:3306/personal_finance";
		String user_name = "root";
		String dpassword = "Pavan@999";
		// TODO Auto-generated method stub
		String user_id = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user_name,dpassword);
			PreparedStatement smt = con.prepareStatement(sql);
			smt.setString(1, user_id);
			
			ResultSet rs = smt.executeQuery();
			if(rs.next()) {
				session.setAttribute("username", user_id);
				response.sendRedirect("Home.jsp");
			}
			else {
				response.sendRedirect("Login.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

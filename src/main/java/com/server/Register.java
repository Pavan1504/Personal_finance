package com.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sql = "insert into login_credentials (email,username,password) values(?,?,?)";
		String url = "jdbc:mysql://localhost:3306/personal_finance";
		String user_name = "root";
		String dpassword = "Pavan@999";
		String email = request.getParameter("email");
		String user_id = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(email + " " + user_id + " " + password);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url,user_name,dpassword);
			PreparedStatement smt = con.prepareStatement(sql);
			smt.setString(1, email);
			smt.setString(2, user_id);
			smt.setString(3, password);
			int i = smt.executeUpdate();
			System.out.print(i + " " + "records inserted");
			con.close();
			response.sendRedirect("Login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

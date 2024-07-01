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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/expenceDisplay")
public class ExpenceDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DAO> list = new ArrayList<>();
		String url = "jdbc:mysql://localhost:3306/personal_finance";
		String user_name = "root";
		String dpassword = "Pavan@999";
		String sql = "select expence_name,amount from expence where username = ?";
		try {
			
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user_name,dpassword);
			PreparedStatement smt = con.prepareStatement(sql);
			smt.setString(1, username);
			ResultSet rs = smt.executeQuery();
			DAO s;
			while(rs.next()) {
				s = new DAO();
				s.setType(rs.getString(1));
				s.setAmount(rs.getInt(2));
				list.add(s);
				
			}
			request.setAttribute("list", list);
			request.setAttribute("name", "Expence");
			smt = con.prepareStatement("select sum(amount) from expence where username = ?");
			smt.setString(1, username);
			ResultSet r = smt.executeQuery();
			r.next();
			int total = r.getInt(1);
			System.out.println(total);
			request.setAttribute("total", total );
			session.setAttribute("expence_total",total);

			request.getRequestDispatcher("list.jsp").forward(request, response);
			
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}

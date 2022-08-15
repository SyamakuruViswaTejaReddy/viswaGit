package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class SaveServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		String name=req.getParameter("name");
		String pass=(req.getParameter("pass"));
		
		
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/Application.properties");
		Properties props= new Properties();
		props.load(in);
		
		Connection con=DBConfig.getConnection(props);
		
		try {
			
			PreparedStatement  stmt= con.prepareStatement("insert into s1 (name,pass) values (?,?)");
			
			stmt.setString(1, name);
			stmt.setString(2, pass);
			
			int x=stmt.executeUpdate();
			
			if(x>0) {
				//out.print("Data  Inserted Successfully");
				resp.sendRedirect("register.jsp");
			}
				
			else {
				out.print("Error While  Inserting a Data");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}

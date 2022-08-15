package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/validate")
public class Validate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int c=0;
		
		PrintWriter out= resp.getWriter();
		resp.setContentType("text/html");
		String name1=req.getParameter("name");
		String pass1=(String)(req.getParameter("pass"));
		Properties  props= new Properties();
		
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/Application.properties");
		props.load(in);
		
		
		Connection conn= DBConfig.getConnection(props);
		
		
		if(conn!=null) {
			
			Statement stmt;
			try {
				stmt = conn.createStatement();
				ResultSet rs=stmt.executeQuery("select * from s1");
				
				while(rs.next()) {
					if(rs.getString(1).equals(name1)==true && rs.getString(2).equals(pass1)==true ) {
						out.println("<br></br>");
						out.println("Successfully Login !!!");
						out.println("<a href='airlines.jsp'><button>Show Airlines</button></a>");	
						c=1;
					}
				}
				if(c==0) {
					out.println("Invalid Credentials...");
					out.println("<a href='login.html'>login</a>");	
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else {
			
			out.print("Error While Connecting Connections");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}

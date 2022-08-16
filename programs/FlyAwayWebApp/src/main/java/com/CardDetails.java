package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/card")
public class CardDetails extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		String cname=req.getParameter("chd");
		String cnum=(req.getParameter("num"));
		
		
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/Application.properties");
		Properties props= new Properties();
		props.load(in);
		
		Connection con=DBConfig.getConnection(props);
		
		try {
			
			PreparedStatement  stmt= con.prepareStatement("insert into card (cname,cnum) values (?,?)");
			
			stmt.setString(1, cname);
			stmt.setString(2, cnum);
			
			int x=stmt.executeUpdate();
			
			if(x>0) {
				
				resp.sendRedirect("payment.jsp");
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

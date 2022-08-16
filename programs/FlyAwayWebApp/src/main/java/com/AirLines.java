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
@WebServlet("/airlines")
public class AirLines extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    int stid=0;
	    int c=10;
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		out.println("welcome to airlines!!!");
		String uname=req.getParameter("uname");
		String frm=req.getParameter("from");
		String tto=req.getParameter("to");
		String dd=req.getParameter("TD");
		String nott=req.getParameter("NOT");
		
		if(frm.equalsIgnoreCase("hyderabad")==true && tto.equalsIgnoreCase("mumbai")==true) {
			stid=1;
		}

		else if(frm.equalsIgnoreCase("hyderabad")==true && tto.equalsIgnoreCase("bangalore")==true) {
			stid=2;
		}

		else if(frm.equalsIgnoreCase("bangalore")==true && tto.equalsIgnoreCase("mumbai")==true) {
			stid=3;
		}

		else if(frm.equalsIgnoreCase("bangalore")==true && tto.equalsIgnoreCase("hyderabad")==true) {
			stid=4;
		}

		else if(frm.equalsIgnoreCase("mumbai")==true && tto.equalsIgnoreCase("hyderabad")==true) {
			stid=5;
		}

		else if(frm.equalsIgnoreCase("mumbai")==true && tto.equalsIgnoreCase("bangalore")==true) {
			stid=6;
		}
		else {
			stid=c+1;
		}
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/Application.properties");
		Properties props= new Properties();
		props.load(in);
		
		Connection con=DBConfig.getConnection(props);
		
		try {
			
			PreparedStatement  stmt= con.prepareStatement("insert into StrSrcDes (uname,frm,tto,dd,nott,stid) values (?,?,?,?,?,?)");
			stmt.setString(1, uname);
			stmt.setString(2, frm);
			stmt.setString(3, tto);
			stmt.setString(4, dd);
			stmt.setString(5,nott );
			stmt.setInt(6, stid);
			
			int x=stmt.executeUpdate();
			
			if(x>0) {
				
				resp.sendRedirect("checksrcdes");
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

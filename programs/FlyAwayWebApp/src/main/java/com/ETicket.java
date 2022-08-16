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
@WebServlet("/eticket")
public class ETicket extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out= resp.getWriter();
		resp.setContentType("text/html");
		out.println("<h1 style=\"background-color:#000000;color:#E6E6FA\">ETicket</h1>");
		out.println("<br>");
		Properties  props= new Properties();
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/Application.properties");
		props.load(in);
		
		
		Connection conn= DBConfig.getConnection(props);
		
		
		if(conn!=null) {
			
			Statement stmt;
			try {
				stmt = conn.createStatement();
				ResultSet rs=stmt.executeQuery("select st.uid,st.uname, st.dd ,src.fr ,src.tt, st.nott,src.price  from SrcDesPrc src,StrSrcDes st where src.stid=st.stid order by st.uid desc limit 1 ");	
				if(rs.next()) {
						out.println("<b style=\"color:#A52A2A\">UId:</b>"+rs.getInt(1)+"<br>");
						out.println("<b style=\"color:#A52A2A\">User:</b>"+rs.getString(2)+"<br>");
						out.println("<b style=\"color:#A52A2A\">Travel_dt:</b>"+rs.getString(3)+"<br>");
						out.println("<b style=\"color:#A52A2A\">Leaving from:</b>"+rs.getString(4)+"<br>");
						out.println("<b style=\"color:#A52A2A\">Going to:</b>"+rs.getString(5)+"<br>");
						out.println("<b style=\"color:#A52A2A\">no.of travellers:</b>"+rs.getInt(6)+"<br>");
						out.println("<b style=\"color:#A52A2A\">Price:</b>"+rs.getInt(6)*rs.getInt(7)+"<br>");
						
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

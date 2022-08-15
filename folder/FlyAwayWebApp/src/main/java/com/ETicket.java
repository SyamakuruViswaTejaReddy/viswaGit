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
		out.println("<center><h1>ETicket</h1></center>");
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
					out.println(" <b>UId</b>"+" "+"<b>User</b>"+" "+"<b>Travel_dt</b>"+" "+"<b>Source</b>"+" "+"<b>Destination</b>"+" "+"<b>no.</b>"+" "+"<b>Price</b>"+" "+"<br>");
					out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(6)*rs.getInt(7)+"<br>");
						//out.println(rs.getInt(5)+"<br>");
						//out.println(rs.getString(7)+"<br>");
						//out.println(rs.getString(2)+"<br>");
						//out.println(rs.getString(3)+"<br>");
						//out.println(rs.getString(4)+"<br>");
						//out.println(rs.getInt(1)+"<br>");
						//out.println(rs.getInt(6)+"<br>");
						//out.println(rs.getInt(8)+"<br>");
						//out.println(rs.getString(9)+"<br>");
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

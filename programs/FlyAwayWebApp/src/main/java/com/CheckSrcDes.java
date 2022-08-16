package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/checksrcdes")
public class CheckSrcDes extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out= resp.getWriter();
		resp.setContentType("text/html");
		Properties  props= new Properties();
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/Application.properties");
		props.load(in);
		
		
		Connection conn= DBConfig.getConnection(props);
		
		
		if(conn!=null) {
			
			Statement stmt;
			try {
				stmt = conn.createStatement();
				ResultSet rs=stmt.executeQuery("select st.dd d,src.fr f,src.tt t,src.price p from SrcDesPrc src,StrSrcDes st where src.stid=st.stid order by st.uid desc limit 1 ");	
				if(rs.next()) {
					out.println("<b>Travel_Date</b>"+" "+"<b>From</b>"+" "+"<b>To</b>"+" "+"<b>Ticket_Price</b>"+" "+"<b>Timings"+"</b>"+"<br>");
					int inn=00;
					int outt=04;
					for(int i=0;i<=5;i++) {
						if(outt==24)
							outt=0;
						out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+inn+"-"+outt+" "+"<a href=book.jsp><button>Book</button></a>"+"<br>");
						inn=inn+4;
						outt=outt+4;
					}
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

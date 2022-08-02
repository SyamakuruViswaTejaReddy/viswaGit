package ValidationDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	  PrintWriter out=resp.getWriter();
	  resp.setContentType("text/html");
	  String userName=req.getParameter("user");
	  String password=req.getParameter("password");
	  if(userName.contentEquals("earth")&& password.contains("1234")){
		  HttpSession sesssion=req.getSession();
		  resp.sendRedirect("dashboard");
	  }
	  else
	  {
		  resp.sendError(404);
	  }
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req,resp);
	}
	

}

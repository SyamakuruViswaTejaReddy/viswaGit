package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Product;
import com.test.SaveObject;
@WebServlet("/addProduct")
public class AddProduct extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		String pname=req.getParameter("pname");
		String pdesc=req.getParameter("pdesc");
		String pavl=req.getParameter("availablep");
		Product p=new Product();
		p.setPname(pname);
		p.setPdesc(pdesc);
		p.setPavl(pavl);
		int count=SaveObject.save(p);
		if(count==0) {
			out.println("no product is inserted");
		}
		else {
			out.println("product inserted");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}

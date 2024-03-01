package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BlManager;
import com.pojo.Register;
@WebServlet("/loginServlet")
public class UserLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Register reg=new Register();
		BlManager manager=new BlManager();
		reg=manager.searchbyEmailpass(email,password);
		if(reg!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("em", reg);
			resp.sendRedirect("welcome.jsp");
		}else {
			out.println("<h3>Error not found data</h3>");
			resp.sendRedirect("UserLogin.jsp");
		}
	}
}

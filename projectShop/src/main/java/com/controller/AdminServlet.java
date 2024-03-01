package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.BlManager;
import com.pojo.Admin;

@WebServlet("/AdminLoginServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        BlManager blManager = new BlManager();
        Admin admin = blManager.searchforAdmin(username, password);
        
      try 
      {
    	  if (admin != null) {
              // Admin credentials are valid, create session and redirect to admin page
              HttpSession session = request.getSession();
              session.setAttribute("adminUsername", username);
              response.sendRedirect("adminpage.jsp");
          } else {
              // Admin credentials are invalid, redirect back to login page
              response.sendRedirect("AdminLoginPage.jsp");
          }
      }catch (Exception e) {
		
    	  e.printStackTrace();
    	  System.err.println(e.getMessage());
	}
    }
}

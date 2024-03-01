package com.controller;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BlManager;
import com.pojo.Addproduct;

public class AddprodServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer productid = Integer.parseInt(req.getParameter("productid"));
		String prodname = req.getParameter("prodname");
		Double price = Double.parseDouble(req.getParameter("price"));
		String paymode = req.getParameter("paymode");
		String availability = req.getParameter("availability");
		BlManager bl = new BlManager();
		Addproduct ap = new Addproduct();
		ap.setPid(productid);
		ap.setProdname(prodname);
		ap.setPrice(price);
		ap.setPaymode(paymode);
		ap.setAvailability(availability);
		bl.saveProdInfo(ap);
		resp.sendRedirect("AddProducts.jsp");
	}
}

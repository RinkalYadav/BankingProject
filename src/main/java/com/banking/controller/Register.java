package com.banking.controller;

import java.io.IOException;

import com.banking.model.Model;
import com.banking.utils.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Customer c = new Customer();
	c.setCname(req.getParameter("cname"));
	c.setCid(req.getParameter("cid"));
	c.setEmail(req.getParameter("email"));
	c.setPwd(req.getParameter("pwd"));
	c.setBal(Integer.parseInt(req.getParameter("bal")));
	c.setPhone(Long.parseLong(req.getParameter("phone")));
	
	Model m = new Model();
	boolean res = m.registerCustomer(c);
	
	if(res == true) {
		resp.sendRedirect("/BankingProject/RegisterSuccess.html");
	}
	else {
		resp.sendRedirect("/BankingProject/RegisterFail.html");
	}
	
}
}

package com.banking.controller;

import java.io.IOException;

import com.banking.model.Model;
import com.banking.utils.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Login")
public class Login extends HttpServlet {
private HttpSession session;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String cid=req.getParameter("cid");
	String pwd = req.getParameter("pwd");
	
	Model m = new Model();
	
	Customer c=m.login(cid, pwd);
	session = req.getSession(true);
	if(c==null) {
		resp.sendRedirect("/BankingProject/LoginFail.html");
	}
	else {
		session.setAttribute("accno", c.getAccno());
		session.setAttribute("cname", c.getCname());
		session.setAttribute("email", c.getEmail());
		resp.sendRedirect("/BankingProject/Home.html");
	}
}
}

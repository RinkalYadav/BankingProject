package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.banking.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/GetBalance")
public class GetBalance extends HttpServlet {


private HttpSession session;
private PrintWriter writer;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
	session = req.getSession();
	int accno = (int)session.getAttribute("accno");
	Model m=new Model();
	int balance = m.getBalance(accno);
	if(balance == 0) {
		resp.sendRedirect("/BankingProject/BalanceFail.html");
	}
	else {
		session.setAttribute("bal",balance);
		resp.sendRedirect("/BankingProject/Balance.jsp");
	}
	}
	catch(Exception e) {
		writer = resp.getWriter();
		writer.print("Session Expired");
	}
}
}

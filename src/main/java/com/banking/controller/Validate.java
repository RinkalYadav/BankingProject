package com.banking.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Validate")
public class Validate extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String npwd = req.getParameter("npwd");
	String cpwd = req.getParameter("cpwd");
	
	if(npwd.equals(cpwd)) {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ChangePassword");
		requestDispatcher.forward(req, resp);
	}
	else {
		resp.sendRedirect("/BankingProject/ChangePwdFail.html");
	}
}
}

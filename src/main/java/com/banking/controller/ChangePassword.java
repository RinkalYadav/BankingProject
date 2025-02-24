package com.banking.controller;

import java.io.IOException;

import com.banking.model.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
private HttpSession session;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String npwd=req.getParameter("npwd");
	Model m = new Model();
	session = req.getSession();
	int accno=(int)session.getAttribute("accno");
	boolean res=m.changePwd(npwd,accno);
	if(res==true) {
		resp.sendRedirect("/BankingProject/ChangePwdSuccess.html");
	}
	else {
		resp.sendRedirect("/BankingProject/ChangePwdFail.html");
	}
}
}

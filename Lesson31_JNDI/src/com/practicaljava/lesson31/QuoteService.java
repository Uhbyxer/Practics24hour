package com.practicaljava.lesson31;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuoteService
 */
@WebServlet("/quote")
public class QuoteService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession(true);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body bgcolor=yellow>");
		out.println("<h2>Hello from QuoteService</h2>");
		
		out.println("Sending a message to the TestQueue");
		
		MessageSender mySender=new MessageSender();
		mySender.sendMessage("IBM 20000000 Buy");
		
		//Destroy the session
		request.getSession(true).invalidate();
	}

}

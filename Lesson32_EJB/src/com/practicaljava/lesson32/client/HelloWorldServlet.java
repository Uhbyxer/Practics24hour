package com.practicaljava.lesson32.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import javax.naming.*;

import com.practicaljava.lesson32.ejb.HelloWorldBean;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB HelloWorldBean myBean;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		try {
//			Context ctx = new InitialContext();
//			HelloWorldBean myBean = (HelloWorldBean) ctx.lookup("java:global/Lesson32_EJB/HelloWorldBean");
			
			 
			PrintWriter out = response.getWriter();
	        out.println("Now, it's time for dependency injection demo 1111: " + myBean.sayHello());

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

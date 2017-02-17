package com.hackbulgaria;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<String> l = new LinkedList<>();
		
		l.add("Kamen");
		l.add("Mamen");
		
		request.getSession().setAttribute("servletName", "index");
		request.getSession().setAttribute("message", "hello");
		request.getSession().setAttribute("title", "Home Page");
		request.getSession().setAttribute("users", l);
		
    	RequestDispatcher view =
			request
    			.getRequestDispatcher("index.jsp");
	    
    	view.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

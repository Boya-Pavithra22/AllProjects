package com.Assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class BalanceServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {	
		 HttpSession session = request.getSession(false); // Don't create new session
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        if (session != null && session.getAttribute("name") != null) {
	            String name = (String) session.getAttribute("name");
	            Double balance = (Double) session.getAttribute("balance");

	            out.println("<h2>Welcome, " + name + "</h2>");
	            out.println("<p>Your account balance is: Rs." + balance + "</p>");
	            out.println("<a href='LogoutServlet'>Logout</a>");
	        } else {
	            out.println("<h3>Session expired. Please <a href='login.html'>login again</a>.</h3>");
	        }
	    }
	}

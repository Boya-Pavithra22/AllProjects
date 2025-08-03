package com.Assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String data = request.getParameter("product"); // e.g., Laptop-50000
	        String[] parts = data.split("-");
	        String name = parts[0];
	        String price = parts[1];

	        out.println("<html><body style='font-family: Arial;'>");
	        out.println("<h2>Enter Quantity for: " + name + "</h2>");
	        out.println("<form action='order' method='post'>");
	        out.println("Quantity: <input type='number' name='qty' min='1' required><br><br>");
	        out.println("<input type='hidden' name='name' value='" + name + "'>");
	        out.println("<input type='hidden' name='price' value='" + price + "'>");
	        out.println("<input type='submit' value='Calculate Bill'>");
	        out.println("</form>");
	        out.println("</body></html>");
	    }
	}

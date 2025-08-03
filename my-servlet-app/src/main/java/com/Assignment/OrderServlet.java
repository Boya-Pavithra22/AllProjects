package com.Assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int qty = Integer.parseInt(request.getParameter("qty"));
        int total = price * qty;

        out.println("<html><body style='font-family: Arial;'>");
        out.println("<h2>Receipt</h2>");
        out.println("<p><strong>Product:</strong> " + name + "</p>");
        out.println("<p><strong>Price per item:</strong> Rs." + price + "</p>");
        out.println("<p><strong>Quantity:</strong> " + qty + "</p>");
        out.println("<p><strong>Total Bill:</strong> Rs." + total + "</p>");
        out.println("</body></html>");
   
	}

}

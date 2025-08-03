package com.Assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accNumber = request.getParameter("accountNumber");
        String password = request.getParameter("password");

        // Dummy validation (you can replace with database validation)
        if (accNumber.equals("12345") && password.equals("12345")) {
            HttpSession session = request.getSession();
            session.setAttribute("name", "Satya Sai");
            session.setAttribute("balance", 50000.0);

            response.sendRedirect("BalanceServlet");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3>Invalid credentials</h3>");
            out.println("<a href='login.html'>Try Again</a>");
        }
    }

	

}

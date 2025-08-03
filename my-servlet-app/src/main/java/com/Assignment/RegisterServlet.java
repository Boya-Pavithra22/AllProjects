package com.Assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String profession = request.getParameter("profession");
        String married = request.getParameter("married") != null ? "Yes" : "No";
        String note = request.getParameter("note");

        out.println("<h2>Registration Successful!</h2>");
        out.println("<p>Name: " + fullname + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Birthday: " + birthday + "</p>");
        out.println("<p>Gender: " + gender + "</p>");
        out.println("<p>Profession: " + profession + "</p>");
        out.println("<p>Married: " + married + "</p>");
        out.println("<p>Note: " + note + "</p>");
    }
}
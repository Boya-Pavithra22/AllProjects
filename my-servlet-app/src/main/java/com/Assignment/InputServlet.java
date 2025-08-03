package com.Assignment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InputServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
        int marks = Integer.parseInt(request.getParameter("marks"));

        request.setAttribute("name", name);
        request.setAttribute("marks", marks);

        RequestDispatcher rd = request.getRequestDispatcher("GradeServlet");
        rd.forward(request, response);
        }

}

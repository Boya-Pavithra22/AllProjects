package com.Assignment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 int id = Integer.parseInt(req.getParameter("id"));
	        Book book = BookDAO.getBook(id);
	        req.setAttribute("book", book);
	        RequestDispatcher rd = req.getRequestDispatcher("edit-book.jsp");
	        rd.forward(req, res);
	}

}

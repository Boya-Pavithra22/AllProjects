package com.Assignment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 int id = Integer.parseInt(req.getParameter("id"));
	        BookDAO.deleteBook(id);
	        res.sendRedirect("listBooks");
	}

}

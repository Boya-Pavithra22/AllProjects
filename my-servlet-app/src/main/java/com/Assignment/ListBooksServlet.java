package com.Assignment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListBooksServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Book> list = BookDAO.listAllBooks();
        req.setAttribute("list", list);
        RequestDispatcher rd = req.getRequestDispatcher("book-list.jsp");
        rd.forward(req, res);
	}

}

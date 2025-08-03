package com.Assignment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateBookServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        int id = Integer.parseInt(req.getParameter("id"));
	        String title = req.getParameter("title");
	        String author = req.getParameter("author");
	        float price = Float.parseFloat(req.getParameter("price"));
	        BookDAO.updateBook(new Book(id, title, author, price));
	        res.sendRedirect("listBooks");
	    }
	}
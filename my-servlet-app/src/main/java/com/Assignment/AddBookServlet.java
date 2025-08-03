package com.Assignment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@SuppressWarnings("serial")
public class AddBookServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String title = req.getParameter("title");
        String author = req.getParameter("author");
        float price = Float.parseFloat(req.getParameter("price"));
        BookDAO.insertBook(new Book(title, author, price));
        res.sendRedirect("listBooks");
    }
}
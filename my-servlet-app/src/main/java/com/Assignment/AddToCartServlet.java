package com.Assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddToCartServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item = request.getParameter("item");
        if (item != null && !item.trim().isEmpty()) {
            Cookie cookie = new Cookie("item_" + System.currentTimeMillis(), item);
            cookie.setMaxAge(60 * 60); // 1 hour
            response.addCookie(cookie);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Item added to cart: " + item + "</h3>");
        out.println("<a href='addItem.html'>Add More Items</a><br>");
        out.println("<a href='ViewCartServlet'>View Cart</a>");
	}

}

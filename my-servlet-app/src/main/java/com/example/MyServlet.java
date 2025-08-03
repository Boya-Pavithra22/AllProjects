package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// The @WebServlet annotation maps this servlet to the /hello URL
@WebServlet("/hello")
public class MyServlet extends HttpServlet {

    // Override the doGet method to handle GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the content type of the response
        response.setContentType("text/html");

        // Get a PrintWriter object to write the response
        PrintWriter out = response.getWriter();

        // Write the HTML response
        out.println("<html>");
        out.println("<head><title>My Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hello from My First STS Servlet!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}

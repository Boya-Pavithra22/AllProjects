<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, servlettasks.Book" %>
<%
    List<Book> list = (List<Book>) request.getAttribute("list");
%>
<html>
<head>
    <title>Book List</title>
</head>
<body>
    <h2>List of Books</h2>
    <a href="add-book.jsp">Add New Book</a>
    <br><br>
    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Actions</th>
        </tr>
        <%
            if (list != null && !list.isEmpty()) {
                for (Book book : list) {
        %>
        <tr>
            <td><%= book.getId() %></td>
            <td><%= book.getTitle() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getPrice() %></td>
            <td>
                <a href="editBook?id=<%= book.getId() %>">Edit</a> |
                <a href="deleteBook?id=<%= book.getId() %>" onclick="return confirm('Are you sure?');">Delete</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">No books available.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
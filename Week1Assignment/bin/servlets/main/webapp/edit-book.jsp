<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="servlettasks.Book" %>
<%
    Book book = (Book) request.getAttribute("book");
%>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
    <h2>Edit Book</h2>
    <form action="updateBook" method="post">
        <input type="hidden" name="id" value="<%= book.getId() %>">
        <label>Title:</label>
        <input type="text" name="title" value="<%= book.getTitle() %>" required><br><br>
        <label>Author:</label>
        <input type="text" name="author" value="<%= book.getAuthor() %>" required><br><br>
        <label>Price:</label>
        <input type="number" step="0.01" name="price" value="<%= book.getPrice() %>" required><br><br>
        <input type="submit" value="Update">
    </form>
    <br>
    <a href="listBooks">Back to List</a>
</body>
</html>
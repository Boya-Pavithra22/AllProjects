<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Book</title>
</head>
<body>
    <h2>Add New Book</h2>
    <form action="addBook" method="post">
        <label>Title:</label>
        <input type="text" name="title" required><br><br>
        <label>Author:</label>
        <input type="text" name="author" required><br><br>
        <label>Price:</label>
        <input type="number" step="0.01" name="price" required><br><br>
        <input type="submit" value="Save">
    </form>
    <br>
    <a href="listBooks">Back to List</a>
</body>
</html>
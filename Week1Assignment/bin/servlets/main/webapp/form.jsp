<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
    <h2>Enter Student Details</h2>
    <form action="result.jsp" method="post">
        Name: <input type="text" name="name" required><br><br>
        Marks: <input type="number" name="marks" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>

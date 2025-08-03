<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Bank Account Form</title>
</head>
<body>
    <h2>Enter Bank Account Details</h2>
    <form action="showAccount.jsp" method="post">
        Account No: <input type="text" name="accountNo" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Balance: <input type="number" name="balance" required><br><br>
        Account Type: 
        <select name="accountType">
            <option>Savings</option>
            <option>Current</option>
        </select><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
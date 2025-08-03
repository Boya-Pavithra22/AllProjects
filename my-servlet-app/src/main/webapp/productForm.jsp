<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Entry</title>
</head>
<body>
    <h2>Enter Product Details</h2>
    <form action="displayProduct.jsp" method="post">
        Product ID: <input type="number" name="productId" required /><br><br>
        Name: <input type="text" name="name" required /><br><br>
        Price: <input type="number" step="0.01" name="price" required /><br><br>
        Quantity: <input type="number" name="quantity" required /><br><br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>

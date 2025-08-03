<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean id="product" class="servlettasks.Product" scope="request" />
<jsp:setProperty name="product" property="*" />
<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
    <h2>Product Details Entered:</h2>
    <table border="1" cellpadding="10">
        <tr><th>ID</th><td><jsp:getProperty name="product" property="productId" /></td></tr>
        <tr><th>Name</th><td><jsp:getProperty name="product" property="name" /></td></tr>
        <tr><th>Price</th><td><jsp:getProperty name="product" property="price" /></td></tr>
        <tr><th>Quantity</th><td><jsp:getProperty name="product" property="quantity" /></td></tr>
    </table>
    <br>
    <a href="productForm.jsp">Enter Another Product</a>
</body>
</html>
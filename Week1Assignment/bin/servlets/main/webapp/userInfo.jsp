<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("username", request.getParameter("username"));
    request.setAttribute("password", request.getParameter("password"));
    request.setAttribute("address", request.getParameter("address"));
    request.setAttribute("newsletter", request.getParameter("newsletter"));
    request.setAttribute("framework", request.getParameterValues("framework"));
    request.setAttribute("gender", request.getParameter("gender"));
    request.setAttribute("favNumber", request.getParameter("favNumber"));
%>

<!DOCTYPE html>
<html>
<head>
    <title>User Submitted Info</title>
</head>
<body>
    <h2>User Submitted Information</h2>
    <p><strong>Username:</strong> ${username}</p>
    <p><strong>Password:</strong> ${password}</p>
    <p><strong>Address:</strong> ${address}</p>
    <p><strong>Newsletter Subscription:</strong> ${newsletter}</p>
    <p><strong>Favorite Frameworks:</strong></p>
    <ul>
        <c:forEach var="fw" items="${framework}">
            <li>${fw}</li>
        </c:forEach>
    </ul>
    <p><strong>Gender:</strong> ${gender}</p>
    <p><strong>Favorite Number:</strong> ${favNumber}</p>
</body>
</html>
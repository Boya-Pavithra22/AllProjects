<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Result</title></head>
<body>
    <h2>Sorry!</h2>
    <p><strong><%= request.getAttribute("studentName") %></strong> failed with <strong><%= request.getAttribute("studentMarks") %></strong> marks.</p>

    <jsp:include page="footer.jsp" />
</body>
</html>
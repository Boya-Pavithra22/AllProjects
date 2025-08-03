<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<jsp:useBean id="account" class="servlettasks.BankAccount" scope="request" />
<jsp:setProperty name="account" property="*" />

<%
    String accType = request.getParameter("accountType");
    session.setAttribute("accountType", accType);
%>

<html>
<head>
    <title>Account Summary</title>
</head>
<body>
    <h2>Bank Account Details</h2>
    <table border="1" cellpadding="10">
        <tr><th>Account Number</th><td>${account.accountNo}</td></tr>
        <tr><th>Name</th><td>${account.name}</td></tr>
        <tr><th>Balance</th><td>${account.balance}</td></tr>
        <tr><th>Account Type</th><td>${sessionScope.accountType}</td></tr>
        <tr>
            <th>Status</th>
            <td>
                ${account.balance >= 1000 ? "Sufficient Balance" : "Low Balance"}
            </td>
        </tr>
    </table>

    <br><a href="accountForm.jsp">Back to Form</a>
</body>
</html>
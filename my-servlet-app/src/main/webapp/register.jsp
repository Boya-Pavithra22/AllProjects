<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2 style="text-align:center;">User Registration</h2>
    <form action="signupvendor" method="post" style="width:400px; margin:auto;">
        <table>
            <tr>
                <td>Full name:</td>
                <td><input type="text" name="fullname" required /></td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td><input type="email" name="email" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required /></td>
            </tr>
            <tr>
                <td>Birthday (yyyy-mm-dd):</td>
                <td><input type="date" name="birthday" required /></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="gender" value="Male" required /> Male
                    <input type="radio" name="gender" value="Female" /> Female
                </td>
            </tr>
            <tr>
                <td>Profession:</td>
                <td>
                    <select name="profession">
                        <option value="Developer">Developer</option>
                        <option value="Designer">Designer</option>
                        <option value="Manager">Manager</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Married?</td>
                <td><input type="checkbox" name="married" value="Yes" /></td>
            </tr>
            <tr>
                <td>Note:</td>
                <td><textarea name="note" rows="4" cols="25"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;">
                    <input type="submit" value="Register" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
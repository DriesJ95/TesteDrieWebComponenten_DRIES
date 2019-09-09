<%--
  Created by IntelliJ IDEA.
  User: Dries
  Date: 9/9/2019
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome ${login}!</h1>
<form method="post" action="logout">
<p>Would you like to log out?<input type="submit" name="logout" value="Log out"></p>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Veselchak
  Date: 11.12.2021
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login page</h1>
<form method="POST" action="${pageContext.request.contextPath}/login">
    <div>
        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="Enter your email"/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter your password"/>
    </div>
    <div>
        <input type="submit" value="Send"/>
    </div>

</form>
</body>
</html>

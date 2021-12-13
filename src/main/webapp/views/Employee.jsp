<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Veselchak
  Date: 11.12.2021
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

User
<table>
    <jsp:useBean id="employees" scope="request" type="java.util.List"/>
    <c:forEach items="${employees}" var="employees">
        <tr>
            <td><c:out value="${employees.firstName}" /></td>
            <td><c:out value="${employees.lastName}" /></td>
            <td><c:out value="${employees.department}" /></td>
            <td><c:out value="${employees.company}" /></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

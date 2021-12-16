<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Veselchak
  Date: 11.12.2021
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees efficiency</title>
</head>
<body>
<div>
    <p>Employees efficiency</p>
    <p>for company ${companyName}</p>
</div>
<p>Общая эффективность: ${totalProductivity}</p>
<div>
    <p>Эффективность по отделам</p>
    <select name="departments" id="departments">
        <c:forEach items="${departments}" var="departments">
            <option><c:out value="${departments}"/></option>
        </c:forEach>
    </select>
    <button onclick="">Показать</button>
</div>

</body>
</html>

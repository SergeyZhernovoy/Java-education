<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: szhernovoy
  Date: 06.12.2016
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRUD</title>
</head>
<body>
<h2 >*** DELETE USER ***</h2>
<form action="${pageContext.servletContext.contextPath}/delete" method = "post">
    email:<br>
    <input type="text" name="email">
    <br><br>
    <input style= "left: auto" type= "submit">
</form>
<br><br>
<table style="border: 1px solid" cellpadding="1" cellspacing="1" border="1">
    <tr><th>name</th><th>login</th><th>email</th><th>create date</th></tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.create}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<br><br>

<p><a href="${pageContext.servletContext.contextPath}/main">back to menu...</a>
</body>
</html>

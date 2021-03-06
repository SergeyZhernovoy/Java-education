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
<h2 >*** UPDATE USER ***</h2>
<form action="${pageContext.servletContext.contextPath}/update" method = "post">
    name:<br>
    <input type="text" name="name" ><br>
    login:<br>
    <input type="text" name="login"><br>
    password:<br>
    <input type="password" name="password"><br>

    <c:choose>
        <c:when test="${root == false}">
            email:<br>
            <input type="text" name="email" value="${email}" disabled><br>
        </c:when>
        <c:when test="${root == true}">
            email:<br>
            <input type="text" name="email"><br>
        </c:when>

    </c:choose>

    <c:if test="${root == true}">
        role:<br>
        <select name="role" size="1">
            <c:forEach items="${roles}" var = "role">
                <option value = "${role.id}"> <c:out value="${role.name}"></c:out></option>
            </c:forEach>
            <option value="10"> root</option>

        </select>
    </c:if>

    <c:if test="${root == false}">
        role:<br>
        <input type="text" name="role" value="${role}" disabled ><br>
    </c:if>

    <br><br>
    <input style= "left: auto" type= "submit">
</form>
<br><br>
<table style="border: 1px solid" cellpadding="1" cellspacing="1" border="1">
    <tr><th>name</th><th>login</th><th>email</th><th>create date</th><th>role</th></tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.create}"></c:out></td>
            <td><c:out value="${user.role.name}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<br><br>

<p><a href="${pageContext.servletContext.contextPath}/main">back to menu...</a>
</body>
</html>

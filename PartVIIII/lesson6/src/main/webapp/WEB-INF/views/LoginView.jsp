<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11.12.2016
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRUD</title>
</head>
<body>
<h2 >*** LOGIN USER ***</h2>
    <c:if test="${error != ''}">
        <div style="background-color: red">
            <c:out value="${error}"/>
        </div>

    </c:if>
    <form action="${pageContext.servletContext.contextPath}/signin" method = "post">
        Login: <input type="text" name="login"><br>
        Password: <input type="password" name="password"><br>
        <input style= "left: auto" type= "submit">
    </form>
</body>
</html>

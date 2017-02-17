<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 18.02.2017
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:url value="/login" var="loginUrl"/>
    <form action="${loginUrl}" method="post">       1
        <c:if test="${param.error != null}">        2
            <p>
                Invalid username and password.
            </p>
        </c:if>
        <c:if test="${param.logout != null}">       3
            <p>
                You have been logged out.
            </p>
        </c:if>
        <p>
            <label for="username">Username</label>
            <input type="text" id="username" name="username"/>	4
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>	5
        </p>
        <input type="hidden"                        6
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <button type="submit" class="btn">Log in</button>
    </form>
</body>
</html>

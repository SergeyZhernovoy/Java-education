<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 05.12.2016
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRUD</title>
</head>
    <body>
    <h2 >*** MENU ***</h2>
         <ol>
            <c:if test="${root == true}">
                <li><a href="${pageContext.servletContext.contextPath}/create">Add user </a></li>
                <li><a href="${pageContext.servletContext.contextPath}/update">Update user</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/delete">Delete user</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/createrole">Add role </a></li>
                <li><a href="${pageContext.servletContext.contextPath}/updaterole">Update role</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/deleterole">Delete role</a></li>
            </c:if>
            <c:if test="${root == false}">
                <li><a href="${pageContext.servletContext.contextPath}/update">Update user</a></li>
            </c:if>
        </ol>
    </body>
</html>

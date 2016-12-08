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
            <li><a href="<%=request.getContextPath()%>/create">Add user </a></li>
            <li><a href="<%=request.getContextPath()%>/update">Update user</a></li>
            <li><a href="<%=request.getContextPath()%>/delete">Delete user</a></li>
        </ol>
    </body>
</html>

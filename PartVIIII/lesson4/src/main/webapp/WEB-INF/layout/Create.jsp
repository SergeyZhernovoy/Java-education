<%@ page import="ru.szhernovoy.model.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="ru.szhernovoy.model.HtmlTable" %>
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
    <h2 >*** CREATE USER ***</h2>
    <form action="<%=request.getContextPath()%>/create" method = "post">
        name:<br>
        <input type="text" name="name" ><br>
        login:<br>
        <input type="text" name="login"><br>
        email:<br>
        <input type="text" name="email">
        <br><br>
        <input style= "left: auto" type= "submit">
        </form>
    <br><br>
    <table style="border: 1px solid" cellpadding="1" cellspacing="1" border="1">
        <tr><th>name</th><th>login</th><th>email</th><th>create date</th></tr>
        <% for(User user: HtmlTable.getInstance().getUser()){ %>
        <tr>
            <td><%=user.getName()%></td>
            <td><%=user.getLogin()%></td>
            <td><%=user.getEmail()%></td>
            <td><%=new Date(user.getCreateDate())%></td>
        </tr>
        <% } %>
    </table>
    <br><br>

    <p><a href="<%=request.getContextPath()%>/menu">back to menu...</a>
    </body>
</html>

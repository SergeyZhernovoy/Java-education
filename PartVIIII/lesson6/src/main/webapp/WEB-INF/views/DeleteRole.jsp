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
<h2 >*** DELETE ROLE ***</h2>
    <form action="${pageContext.servletContext.contextPath}/deleterole" method = "post">
        name:<input type="text" name="name" ><br>
        <input style= "left: auto" type= "submit">
    </form>
    <br><br>
    <table style="border: 1px solid" cellpadding="1" cellspacing="1" border="1">
        <tr><th>name</th><th>root</th></tr>
        <c:forEach items="${roles}" var="role">
            <tr>
                <td><c:out value="${role.name}"></c:out></td>
                <td align="center">
                    <c:choose>
                        <c:when test="${role.root=='false'}">

                        </c:when>
                        <c:when test="${role.root=='true'}">
                            *
                        </c:when>
                        <c:otherwise>

                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br><br>

<p><a href="${pageContext.servletContext.contextPath}/main">back to menu...</a>
</body>
</html>

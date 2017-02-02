<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01.02.2017
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


</html>


<head>
    <title>Car store</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
ЭТО ПРОВЕРКА
    <c:set var="oneuser" target="${user}"/>
    <c:if test="${not empty oneuser}">
        <h1>Мы получили пользователя по имени - ${oneuser.name}</h1>
    </c:if>




</head>
<body>

</body>
</html>

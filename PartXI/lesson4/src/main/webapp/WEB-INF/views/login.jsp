<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 19.02.2017
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Car store</title>
</head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Car store</h1>
                    <p>View cars</p>
                </div>
            </div>
        </section>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Please sign in</h3>
                        </div>
                        <div class="panel-body">
                            <c:if test="${not empty error}">
                                <div class="alert alert-danger">
                                    <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
                                </div>
                            </c:if>
                            <form action="/login" method="post">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="User Name"
                                               name='username' type="text">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password"
                                               name='password' type="password" value="">
                                    </div>
                                    <input class="btn btn-lg btn-success btn-block"
                                           type="submit" value="Login">
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
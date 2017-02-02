<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01.02.2017
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Car store</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/car.png" type="image/png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
    <body>
    <h1>${greeting}</h1>
    <div class="container-fluid">
        <div class="row content">
            <div class="col-sm-3 sidenav">
                <h4>Авторизация</h4>
                <c:choose>
                    <c:when test="${succesAuto}">
                        <div>
                            <h3><span class="label label-info">Успешная авторизация</span></h3>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <form id="autorization">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="login" type="text" class="form-control" name="login" placeholder="Login" >
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="password" type="password" class="form-control" name="password" placeholder="Password" >
                            </div>
                            <br>
                            <button type="button" class="btn btn-link" id="auth-btn">Ввойти</button>
                            <button type="button" class="btn btn-link" id="add-user-btn">Регистрация</button>
                        </form>

                        <c:if test="${not empty succesAuto && !succesAuto}">
                            <div >
                                <span style="color: red; ">Пожалуйста, проверьте правильность написания логина и пароля!</span>
                            </div>
                        </c:if>
                    </c:otherwise>
                </c:choose>

                <c:if test="${succesAuto}">
                    <button type="button" class="btn btn-link" id="move-order-page" >Добавить объявление</button>
                </c:if>
                <br>
            </div>

            <div class="col-sm-9">
                <h4 align="center">Объявления о продаже автомобилей</h4>
                <br>

                <div class="container">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Продано</th>
                            <th>Автомобиль</th>
                            <th>Цена</th>
                            <th>Пробег</th>
                            <th>Год</th>
                            <th>Галлерея</th>
                            <th>Редактировать</th>
                        </tr>
                        </thead>
                        <tbody id = "table-body">
                        <c:forEach var="order" items="${orders}">
                            <td><c:out value="${order.sold}"></c:out></td>
                            <td><c:out value="${order.carName}"></c:out></td>
                            <td><c:out value="${order.price}"></c:out></td>
                            <td><c:out value="${order.mile}"></c:out></td>
                            <td><c:out value="${order.data}"></c:out></td>
                            <td><button type='button' class='btn btn-link pictures' onclick= "" >Галлерея</button></td>
                            <c:choose>
                                <c:when test="${succesAuto}">
                                    <td><button type='button' class='btn btn-link' onclick=""><i class= 'material-icons' style='font-size:20px'>mode_edit</i></button></td>
                                </c:when>
                                <c:otherwise>
                                    <td><button type='button' class='btn btn-link' disabled><i class= 'material-icons' style='font-size:20px'>mode_edit</i></button></td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="modalWindow" hidden >
        <form>
            <button type="button" class="btn btn-default btn-close-modal">закрыть</button>
        </form>

        <div class="container">
            <br>
            <div id="myCarousel" class="carousel slide" data-ride="carousel">

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox" id="carousel-body">

                </div>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>

    </body>
</html>

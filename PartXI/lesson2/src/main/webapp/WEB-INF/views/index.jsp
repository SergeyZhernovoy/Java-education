<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31.01.2017
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Car store</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../css/carstore.css">
    <link rel="shortcut icon" href="../images/car.png" type="image/png">
    <script src="../js/carstore.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-3 sidenav">
            <h4>Авторизация</h4>

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

            <div id="info_success_auth" hidden>
                <h3><span class="label label-info">Успешная авторизация</span></h3>
            </div>

            <br>
            <button type="button" class="btn btn-link" id="move-order-page" hidden>Добавить объявление</button>
        </div>

        <div class="col-sm-9">
            <h4 align="center">Объявления о продаже автомобилей</h4>
            <br>

            <div align="center">
                <h5 align="center" >Фильтр объявлений</h5>
                <br>
                <form class="form-inline">
                    <div class="form-group">
                        Цена не более:
                        <input type="number" class="form-control"  placeholder="Цена" id = "price">
                    </div>
                    <div class="form-group">
                        Пробег не более:
                        <input type="number" class="form-control"  placeholder="Пробег" id = "miles">
                    </div>
                    <div class="form-group">
                        Тип кузова:
                        <select id="body"  class="selectpicker form-control" data-width="35%">

                        </select>
                    </div>
                    <div class="form-group">
                        Трансмиссия:
                        <select id="transsmission"  class="selectpicker form-control" data-width="35%">

                        </select>
                    </div>


                    <button type="button" class="btn btn-default btn-filter" >Поиск</button>
                </form>

            </div>
            <br><br>
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

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="modalWindow">
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

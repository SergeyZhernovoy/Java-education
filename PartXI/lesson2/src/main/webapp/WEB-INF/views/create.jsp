<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31.01.2017
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Car store</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/carstore.css">
        <link rel="shortcut icon" href="images/car.png" type="image/png">
        <script src="js/create.js" type="text/javascript"></script>

    </head>
    <body>
        <h2 id="titleOrder" align="center">Добавление нового объявления</h2>
        <br>
        <div class="container">
            <form>
                <div class="form-group">
                    <label for="name">Название</label>
                    <input type="text" class="form-control" id="name">
                </div>

                <div class="form-group">
                    <label for="model"> Брэнд</label>
                    <select id="model"  class="selectpicker form-control" data-width="35%">

                    </select>
                </div>

                <div class="form-group">
                    <label for="body">Кузов</label>
                    <select id="body"  class="selectpicker form-control" data-width="35%">

                    </select>
                </div>

                <div class="form-group">
                    <label for="drivetype">Привод</label>
                    <select id="drivetype"  class="selectpicker form-control" data-width="35%">

                    </select>
                </div>

                <div class="form-group">
                    <label for="engine"> Вид двигателя</label>
                    <select id="engine"  class="selectpicker form-control" data-width="35%">

                    </select>
                </div>

                <div class="form-group" >
                    <label for="transsmission" > Транссмиссия</label>
                    <select id="transsmission"  class="selectpicker form-control" data-width="35%">

                    </select>
                </div>

                <div class="form-group">
                    <label for="price">Цена</label>
                    <input type="number" class="form-control" id="price" placeholder="Введите цену">
                </div>
                <div class="form-group">
                    <label for="mileage">Пробег</label>
                    <input type="number" class="form-control" id="mileage" placeholder="Введите пробег">
                </div>

                <div class="form-group">
                    <label for="release">Год выпуска</label>
                    <input type="date" class="form-control" id="release" placeholder="Введите год выпуска">
                </div>

                <div>
                    <label for="sold">Продано</label>
                    <input type="checkbox" id="sold">
                </div>

                <button type="button" class="btn btn-warning" id="add-order-btn">Добавить объявление</button>
            </form>
        </div>
        <br>
        <h4 align="center">Добавить изображения к объявлению</h4>
        <div class="container">
            <form class="form-inline" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="file" accept="image/jpeg"  multiple id="file-image">
                    <input type="button" value="Добавить изображение" id = "file-btn-load">
                </div>
            </form>
        </div>
    </body>
</html>

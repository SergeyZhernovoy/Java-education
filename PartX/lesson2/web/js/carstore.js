/**
 * Created by Admin on 11.01.2017.
 */
var login_result;


$(document).ready(function () {

     fill();

     $("#auth-btn").click(function () {
        var login = $("#login");
        var password = $("#password");

        if(login != '' && password != ''){
            $.ajax({
                url: "signin",
                method: "post",
                data: {
                    'login': login.val(),
                    'password': password.val(),
                    'addUser' : false},
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    login_result = Boolean(result.success);
                    if (login_result) {
                        $("#autorization").hide();
                        $("#info_success_auth").show();
                        $("#move-order-page").show();
                    }
                    else {
                        alert("Bad try sign in. Try again");
                    }
                }
            });
        }
    });

    $("#add-user-btn").click(function () {
        var login = $("#login");
        var password = $("#password");

        if(login != '' && password != ''){
            $.ajax({
                url: "signin",
                method: "post",
                data: {
                    'login': login.val(),
                    'password': password.val(),
                    'addUser' : true},
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    login_result = Boolean(result.success);
                    if (login_result) {
                        alert("Успешная регистрация")
                        $("#autorization").hide();
                        $("#info_success_auth").show();
                        $("#move-order-page").show();
                    }
                    else {
                        alert("Bad try sign in. Try again");
                    }
                }
            });
        }
    });

    $("#move-order-page").click(function () {

        if(login_result){

            location.href = "create.html";
            fillBody(); //1
            fillDrive(); //3
            fillEngine(); //4
            fillModel(); //2
            fillTranssm(); //5
        }
    });

})

function fill() {

    if(location.href == "create.html"){
        alert(3);
    }
}


function fillBody() {
    $.ajax({
        url: "fill",
        method: "get",
        data: {'type': 1},
        complete: function (data) {
            var result = JSON.parse(data.responseText);
            if(result.item != ''){
                var next =  JSON.parse(result.item);
                var optional = "";
                for (var i = 0; i != next.length; ++i) {
                    optional += "<option value = "+next[i].id+">" + next[i].name + "</option>";
                }
                var dropdownMenu = document.getElementById("body");
                dropdownMenu.innerHTML = optional;
            }
        }
    });
}

function fillModel() {
    $.ajax({
        url: "fill",
        method: "get",
        data: {'type': 2},
        complete: function (data) {
            var result = JSON.parse(data.responseText);
            if(result.item != ''){
                var next =  JSON.parse(result.item);
                var optional = "";
                for (var i = 0; i != next.length; ++i) {
                    optional += "<option value = "+next[i].id+">" + next[i].name + "</option>";
                }
                var dropdownMenu = document.getElementById("model");
                dropdownMenu.innerHTML = optional;
            }

        }
    });
}

function fillDrive() {
    $.ajax({
        url: "fill",
        method: "get",
        data: {'type': 3},
        complete: function (data) {
            var result = JSON.parse(data.responseText);
            if(result.item != ''){
                var next =  JSON.parse(result.item);
                var optional = "";
                for (var i = 0; i != next.length; ++i) {
                    optional += "<option value = "+next[i].id+">" + next[i].name + "</option>";
                }
                var dropdownMenu = document.getElementById("drivetype");
                dropdownMenu.innerHTML = optional;
            }

        }
    });
}

function fillEngine() {
    $.ajax({
        url: "fill",
        method: "get",
        data: {'type': 4},
        complete: function (data) {
            var result = JSON.parse(data.responseText);
            if(result.item != ''){
                var next =  JSON.parse(result.item);
                var optional = "";
                for (var i = 0; i != next.length; ++i) {
                    optional += "<option value = "+next[i].id+">" + next[i].name + "</option>";
                }
                var dropdownMenu = document.getElementById("engine");
                dropdownMenu.innerHTML = optional;
            }

        }
    });
}

function fillTranssm() {
    $.ajax({
        url: "fill",
        method: "get",
        data: {'type': 5},
        complete: function (data) {
            var result = JSON.parse(data.responseText);
            if(result.item != ''){
                var next =  JSON.parse(result.item);
                var optional = "";
                for (var i = 0; i != next.length; ++i) {
                    optional += "<option value = "+next[i].id+">" + next[i].name + "</option>";
                }
                var dropdownMenu = document.getElementById("transsmission");
                dropdownMenu.innerHTML = optional;
            }

        }
    });
}
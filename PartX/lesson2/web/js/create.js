/**
 * Created by admin on 13.01.2017.
 */

var login_result = false;
var order_id = -1;

$(document).ready(function () {

    fillBody();
    fillDrive();
    fillEngine();
    fillModel();
    fillTranssm();
    controlSession();

    $("#add-order-btn").click(function () {
        var name = $("#name");
        var model = $("#model");
        var body = $("#body");
        var drivetype = $("#drivetype");
        var engine = $("#engine");
        var transsmission = $("#transsmission");
        var price = $("#price");
        var mile = $("#mileage");
        var release = $("#release");
        if(login_result){
            $.ajax({
                url: "create",
                method: "post",
                data: {
                    'name': name.val(),
                    'model': model.val(),
                    'body' : body.val(),
                    'drivetype' : drivetype.val(),
                    'engine' : engine.val(),
                    'transsmission' : transsmission.val(),
                    'price' : price.val(),
                    'release' : release.val(),
                    'mile'  : mile.val()},
                complete: function (data) {
                    order_id = JSON.parse(data.responseText);
                    if (order_id !=-1) {
                        alert("Вы успешно добавили объявление. Теперь можно добавить к нему изображения");
                        $('#add-order-btn').prop('disabled',true);
                    }
                }
            });
        }
    });

})


function controlSession() {
    $('#add-order-btn').prop('disabled',true);
    $.ajax({
        url: "signin",
        method: "get",
        complete: function (data) {
            var result = JSON.parse(data.responseText);
            login_result = Boolean(result.success);
            $('#add-order-btn').prop('disabled',!login_result);
        }
    });
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
        data: {'type': 4},
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
        data: {'type': 3},
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
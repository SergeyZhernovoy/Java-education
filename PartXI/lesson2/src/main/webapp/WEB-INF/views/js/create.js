/**
 * Created by admin on 13.01.2017.
 */

var login_result = false;
var order_id = -1;
var carId = -1;

$(document).ready(function () {

    fillBody();
    fillDrive();
    fillEngine();
    fillModel();
    fillTranssm();
    controlSession();
    fillExistOrder();

    $("#add-order-btn").click(function () {

        var sold = false;

        if($("#sold").prop('checked')){
            var sold = true;
        }

        var release = $("#release");
        var car = {
            'name' : $("#name").val(),
            'body' : { 'id': $("#body").val()},
            'driveType' : {'id' : $("#drivetype").val() },
            'engine' : {'id' : $("#engine").val()},
            'transmission' : {'id':$("#transsmission").val()},
            'model' : {'id': $("#model").val()}
            };
        var order = {
            'price' : $("#price").val(),
            'milesage' : $("#mileage").val(),
            'sold' : sold
        };

        if(login_result){
            $.ajax({
                url: "create",
                method: "post",
                datatype : 'JSON',
                data: {
                    'order' : JSON.stringify(order),
                    'car'   : JSON.stringify(car),
                    'release' : release.val(),
                    'carId' : carId
                },
                complete: function (data) {
                    order_id  = JSON.parse(data.responseText);
                    if (order_id !=-1) {
                        alert("Вы успешно добавили объявление. Теперь можно добавить к нему изображения");
                        $('#add-order-btn').prop('disabled',true);
                    }
                }
            });
        }
    });


    $("#file-btn-load").click(function(e) {

        var data = new FormData();

        $.each($('#file-image')[0].files, function(i, file) {
            data.append('file-'+i, file);
        });

        if(order_id != -1){
            $.ajax({
                url: "image",
                processData : false,
                contentType : false,
                method: "post",
                data: data,
                complete: function (data) {
                    var result  = JSON.parse(data.responseText);
                    if (result.success) {
                        alert("Вы успешно загрузили изображение. Можно добавить ещё");
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

function fillExistOrder() {
      $.ajax({
        url: "edit",
        method: "get",
        complete: function (data) {
            var struct = JSON.parse(data.responseText);
            order_id = struct.order;
            if (order_id != -1) {
                var docOrder = struct.orderProperties[0]; // у нас только одна строка в массиве

                $("#model").val(docOrder.modelId);
                $("#body").val(docOrder.bodyId);
                $("#drivetype").val(docOrder.drivetype);
                $("#engine").val(docOrder.engineId);
                $("#transsmission").val(docOrder.transsmId);
                $("#name").val(docOrder.carName);
                $("#price").val(docOrder.price);
                $("#mileage").val(docOrder.mile);
                $("#release").val(docOrder.modelId);
                $("#sold").prop('checked',docOrder.sold)

                $("#date").val(docOrder.data);

                $("#titleOrder").html("Обновить объявление");
                $("#add-order-btn").html("Обновить");

                carId = docOrder.carId;

            }
        }
    });
}

function fillBody() {
    $.ajax({
        url: "fill",
        method: "get",
        data: {'type': 1},
        complete: function (data) {
            var next = JSON.parse(data.responseText);
            if(next != ''){
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
            var next = JSON.parse(data.responseText);
            if(next != ''){
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
            var next = JSON.parse(data.responseText);
            if(next != ''){
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
            var next = JSON.parse(data.responseText);
            if(next != ''){
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
            var next = JSON.parse(data.responseText);
            if(next != ''){
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
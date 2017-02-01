/**
 * Created by Admin on 11.01.2017.
 */
var login_result;

$(document).ready(function () {

     controlSession();
     updateTable();
     fillTranssm();
     fillBody();


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
                        directView();
                        updateTable();
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
                        directView();
                        updateTable();
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
            $.ajax({
                url: "edit",
                method: "post",
                data: { "order" : -1}
            });
            location.href = "create.html";
        }
    });

    $('.btn-close-modal').click(function(){ //Что будет происходить по клику по форме
        $('.modalWindow').fadeOut('slow');
        $('.carousel-inner').html('');
    });

    $('.btn-filter').click(function(){ //Что будет происходить по клику по форме
       filterTable();
    });

})


function controlSession() {
    $.ajax({
        url: "signin",
        method: "get",
        complete: function (data) {
            var result = JSON.parse(data.responseText);
            login_result = Boolean(result.success);
            directView();
        }
    });
}

function directView() {
    if (login_result) {
        $("#autorization").hide();
        $("#info_success_auth").show();
        $("#move-order-page").show();
    }
}

function updateTable(){
       $.ajax({
            url: "create",
            method: "get",
            complete: function (data) {
                var result =  JSON.parse(data.responseText);
                var userId =  result.currentUser;
                var orders   =  JSON.parse(result.orders);
                if(result.orders != ''){
                    var optional = "";
                    for (var i = 0; i != orders.length; ++i) {
                        var userOrder = orders[i].userId;
                        optional += "<tr>";
                        optional += "<td>"+orders[i].sold+"</td>";
                        optional += "<td>"+orders[i].carName+"</td>";
                        optional += "<td>"+orders[i].price+"</td>";
                        optional += "<td>"+orders[i].mile+"</td>";
                        optional += "<td>"+orders[i].data+"</td>";
                        optional += "<td><button type='button' class='btn btn-link pictures' onclick= 'callGallery(" + orders[i].orderId + ")' >Галлерея</button></td>";
                        if(userOrder == userId){
                            optional += "<td><button type='button' class='btn btn-link' onclick= 'editOrder(" + orders[i].orderId + ")' ><i class= 'material-icons' style='font-size:20px'>mode_edit</i></button></td>";
                        } else {
                            optional += "<td><button type='button' class='btn btn-link' disabled ><i class= 'material-icons' style='font-size:20px'>mode_edit</i></button></td>";
                        }
                        optional += "</tr>";
                    }
                    var table = document.getElementById("table-body");
                    table.innerHTML = optional;
                }
            }
        });
}

function filterTable(){

    var filter = {};
    if($("#price").val() != '') {
        filter['price'] = $("#price").val();
    }
    if($("#miles").val() != '') {
        filter['milesage'] = ("#miles").val();
    }
    if($("#body").val() != '') {
        filter['body']= $("#body").val();
    }
    if($("#transsmission").val() != '') {
        filter['transmission'] = $("#transsmission").val();
    }

    $.ajax({
        url: "cut",
        method: "get",
        datatype : 'JSON',
        data: {
            'filter' : JSON.stringify(filter)
        },
        complete: function (data) {
            var result =  JSON.parse(data.responseText);
            var userId =  result.currentUser;
            var orders   =  result.orders;
            if(orders != ''){
                var optional = "";
                for (var i = 0; i != orders.length; ++i) {
                    var userOrder = orders[i].userId;
                    optional += "<tr>";
                    optional += "<td>"+orders[i].sold+"</td>";
                    optional += "<td>"+orders[i].carName+"</td>";
                    optional += "<td>"+orders[i].price+"</td>";
                    optional += "<td>"+orders[i].mile+"</td>";
                    optional += "<td>"+orders[i].data+"</td>";
                    optional += "<td><button type='button' class='btn btn-link pictures' onclick= 'callGallery(" + orders[i].orderId + ")' >Галлерея</button></td>";
                    if(userOrder == userId){
                        optional += "<td><button type='button' class='btn btn-link' onclick= 'editOrder(" + orders[i].orderId + ")' ><i class= 'material-icons' style='font-size:20px'>mode_edit</i></button></td>";
                    } else {
                        optional += "<td><button type='button' class='btn btn-link' disabled ><i class= 'material-icons' style='font-size:20px'>mode_edit</i></button></td>";
                    }
                    optional += "</tr>";
                }
                var table = document.getElementById("table-body");
                table.innerHTML = optional;
            }
        }
    });
}


function callGallery(orderId) {
    $.ajax({
        url: "image",
        method: "get",
        data: {'order': orderId},
        complete: function (data) {

            var images = JSON.parse(data.responseText);
            if (images != '') {
                var optional = "";
                for (var i = 0; i != images.length; ++i) {

                    optional += "<div class='item active'>";

                    optional += "<img src= '" + images[i] + "'   width='460' height='345'>";

                    optional += "</div>";
                }
                var table = document.getElementById("carousel-body");
                table.innerHTML = optional;
            }
        }
    });
    $('.modalWindow').fadeIn('slow');

}

function editOrder(orderId) {
        $.ajax({
            url: "edit",
            method: "post",
            datatype : 'json',
            data : {"order": orderId},
            complete: function (data) {
                location.href = "create.html";
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
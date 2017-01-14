/**
 * Created by Admin on 11.01.2017.
 */
var login_result;


$(document).ready(function () {

     controlSession();


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
        }
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
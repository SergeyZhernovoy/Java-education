/**
 * Created by Admin on 11.01.2017.
 */
$(document).ready(function () {

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
                    if (Boolean(result.success)) {
                        $("#autorization").hide();
                        $("#info_success_auth").show();
                        $("#add_btn").show();
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
                    if (Boolean(result.success)) {
                        alert("Успешная регистрация")
                        $("#autorization").hide();
                        $("#info_success_auth").show();
                        $("#add_btn").show();
                    }
                    else {
                        alert("Bad try sign in. Try again");
                    }
                }
            });
        }
    });


})
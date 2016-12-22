/**
 * Created by dort on 20.12.16.
 */

$(document).ready(function () {

    $("#auth-btn").click(function () {

        var login = $("#login");
        var password = $("#password");
        if (login != '') {
            $.ajax({
                url: "signin",
                method: "post",
                data: {'login': login.val(),'password': password.val()},
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if(Boolean(result.isValid)){
                        location.href = result.nextPage;
                    }
                    else{
                        alert("Please input correct login");
                    }
                }
            });
        }else{
            alert("Please input correct login");
        }
    });


    $("#create-btn").click(function () {

        var login = $("#login_field");
        var password = $("#password_field");
        var email = $("#email_field");
        var city = $("#city_field");
        var country = $("#country_field");

        if (login != '') {
            $.ajax({
                url: "create",
                method: "post",
                data: {'login': login.val(),
                       'password': password.val(),
                       'email':email.val(),
                       'city': city.val(),
                       'country': country.val()
                },
                datatype: 'json',
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if(Boolean(result.successCreate)){
                        alert("Success create user")
                    }
                    else{
                        alert("Bad try create user. Try again");
                    }
                }
            });
        }else{
            alert("Bad try create user. Try again");
        }
    });

    $("#collapse4").click(function () {
            $.ajax({
                url: "info",
                method: "get",
                datatype: 'json',
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if(Boolean(result.successCreate)){
                        alert("Success create user")
                    }
                    else{
                        alert("Bad try create user. Try again");
                    }
                }
            });
    });

});



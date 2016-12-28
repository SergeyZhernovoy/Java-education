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
                data: {'login': login.val(), 'password': password.val()},
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if (Boolean(result.isValid)) {
                        location.href = result.nextPage;
                    }
                    else {
                        alert("Please input correct login");
                    }
                }
            });
        } else {
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
                data: {
                    'login': login.val(),
                    'password': password.val(),
                    'email': email.val(),
                    'city': city.val(),
                    'country': country.val()
                },
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if (Boolean(result.successCreate)) {
                        alert("Success create user")
                    }
                    else {
                        alert("Bad try create user. Try again");
                    }
                }
            });
        } else {
            alert("Bad try create user. Try again");
        }
    });

    $("#update-btn").click(function () {

        var login = $("#ulogin_field");
        var password = $("#upassword_field");
        var email = $("#uemail_field");
        var city = $("#ucity_field");
        var country = $("#ucountry_field");

        if (login != '') {
            $.ajax({
                url: "update",
                method: "post",
                data: {
                    'login': login.val(),
                    'password': password.val(),
                    'email': email.val(),
                    'city': city.val(),
                    'country': country.val()
                },
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if (Boolean(result.successUpdate)) {
                        alert("Success update user")
                    }
                    else {
                        alert("Bad try update user. Try again");
                    }
                }
            });
        } else {
            alert("Bad try update user. Try again");
        }
    });




    $("#collapse3_id").click(function () {
        $.ajax({
            url: "info",
            method: "get",
            datatype: 'json',
            data: {
                'city': 'false',
                'country': 'false',
                'login': 'true',
                'user': 'false'
            },
            complete: function (data) {
                var result = JSON.parse(data.responseText);
                if(result.login != ''){
                    var logins =  JSON.parse(result.login);
                    var optional = "";
                    for (var i = 0; i != logins.length; ++i) {
                        optional += "<option value = "+logins[i].log+">" + logins[i].log + "</option>";
                    }
                    var dropdownMenu = document.getElementById("dlogin_field");
                    dropdownMenu.innerHTML = optional;
                }
            }
        });
    });

    $("#delete-btn").click(function () {

        var login = $("#dlogin_field");
        if (login != '') {
            $.ajax({
                url: "delete",
                method: "post",
                data: {'login': login.val()},
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if (Boolean(result.successDelete)) {
                        alert("Success delete user");
                    }
                    else {
                        alert("Bad try delete user. Try again");
                    }
                }
            });
        } else {
            alert("Bad try delete user. Try again");
        }
    });




    $("#collapse1_id").click(function () {
          $.ajax({
            url: "info",
            method: "get",
            datatype: 'json',
            data: {
                'city': 'true',
                'country': 'true',
                'login': 'false',
                'user': 'false'
            },
            complete: function (data) {
                var result = JSON.parse(data.responseText);
                if(result.country != ''){
                   var countries =  JSON.parse(result.country);
                   var optional = "";
                    for (var i = 0; i != countries.length; ++i) {
                        optional += "<option value = "+countries[i].id+">" + countries[i].name + "</option>";
                    }

                   var dropdownMenu = document.getElementById("country_id");
                   dropdownMenu.innerHTML = optional;
                 }

                if(result.city != ''){
                    var optional = "";
                    var city =  JSON.parse(result.city);
                    for (var i = 0; i != city.length; ++i) {
                        optional += "<option value = "+city[i].id+">" + city[i].name + "</option>";
                    }
                    var dropdownMenu = document.getElementById("city_id");
                    dropdownMenu.innerHTML = optional;
                }

            }
        });
    });

    $("#collapse2_id").click(function () {
        $.ajax({
            url: "info",
            method: "get",
            datatype: 'json',
            data: {
                'city': 'true',
                'country': 'true',
                'login': 'true',
                'user': 'false'
            },
            complete: function (data) {
                var result = JSON.parse(data.responseText);
                if(result.country != ''){
                    var countries =  JSON.parse(result.country);
                    var optional = "";
                    for (var i = 0; i != countries.length; ++i) {
                        optional += "<option value = "+countries[i].id+">" + countries[i].name + "</option>";
                    }

                    var dropdownMenu = document.getElementById("ucountry_field");
                    dropdownMenu.innerHTML = optional;
                }

                if(result.city != ''){
                    var optional = "";
                    var city =  JSON.parse(result.city);
                    for (var i = 0; i != city.length; ++i) {
                        optional += "<option value = "+city[i].id+">" + city[i].name + "</option>";
                    }
                    var dropdownMenu = document.getElementById("ucity_field");
                    dropdownMenu.innerHTML = optional;
                }

                if(result.login != ''){
                    var logins =  JSON.parse(result.login);
                    var optional = "";
                    for (var i = 0; i != logins.length; ++i) {
                        optional += "<option value = "+logins[i].log+">" + logins[i].log + "</option>";
                    }
                    var dropdownMenu = document.getElementById("ulogin_field");
                    dropdownMenu.innerHTML = optional;
                }
            }
        });
    });

    $("#collapse4_id").click(function () {
        $.ajax({
            url: "info",
            method: "get",
            datatype: 'json',
            data: {
                'city': 'false',
                'country': 'false',
                'login': 'false',
                'user': 'true'
            },
            complete: function (data) {
                var result = JSON.parse(data.responseText);
                if(result.user != ''){
                    var user =  JSON.parse(result.user);
                    var optional = "";
                    for (var i = 0; i != user.length; ++i) {
                        optional += "<tr>";
                        optional += "<td>"+user[i].login+"</td>";
                        optional += "<td>"+user[i].email+"</td>";
                        optional += "<td>"+user[i].city+"</td>";
                        optional += "<td>"+user[i].country+"</td>";
                        optional += "<td>"+user[i].date+"</td>";
                        optional += "<td>"+user[i].password+"</td>";
                        optional += "</tr>";
                    }
                    var dropdownMenu = document.getElementById("tdbody");
                    dropdownMenu.innerHTML = optional;
                }


            }
        });
    });


});


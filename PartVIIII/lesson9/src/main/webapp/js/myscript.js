/**
 * Created by dort on 20.12.16.
 */

$(document).ready(function () {

    $("#auth-btn").click(function () {

        var login = $("#role");
        if (login != '') {
            $.ajax({
                url: "signin",
                method: "post",
                data: {'login': login.val()},
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

        var login = $("#login");
        var role = $("#role");
        var address = $("#address");
        var music_type = $("#music_type");

        if (login != '') {
            $.ajax({
                url: "create",
                method: "post",
                data: {
                    'login': login.val(),
                    'role': role.val(),
                    'address': address.val(),
                    'music_type': music_type.val()},
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if (Boolean(result.successCreate)) {
                        alert("Success create user");
                        clear();
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

    function clear() {
        $('input').val('');
    };


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


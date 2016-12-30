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

    $("#addr-btn").click(function () {

        var address = $("#Address_field");
        if (address != '') {
            $.ajax({
                url: "info",
                method: "get",
                datatype: 'json',
                data: {
                    'address': address.val(),
                    'music': '',
                    'role': '',
                    'roleAll': ''
                },
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if(result.user != ''){
                        var user =  JSON.parse(result.user);
                        var optional = "";
                        for (var i = 0; i != user.length; ++i) {
                            optional += "<tr>";
                            optional += "<td>"+user[i].login+"</td>";
                            optional += "<td>"+user[i].music_type+"</td>";
                            optional += "<td>"+user[i].address+"</td>";
                            optional += "<td>"+user[i].role+"</td>";
                            optional += "</tr>";
                        }
                        var dropdownMenu = document.getElementById("tdbody");
                        dropdownMenu.innerHTML = optional;

                    }
                }
            });
        }
    });

    $("#role-btn").click(function () {

        var role = $("#Role_field");
        if (role != '') {
            $.ajax({
                url: "info",
                method: "get",
                datatype: 'json',
                data: {
                    'address': '',
                    'music': '',
                    'role': role.val(),
                    'roleAll': ''
                },
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if(result.user != ''){
                        var user =  JSON.parse(result.user);
                        var optional = "";
                        for (var i = 0; i != user.length; ++i) {
                            optional += "<tr>";
                            optional += "<td>"+user[i].login+"</td>";
                            optional += "<td>"+user[i].music_type+"</td>";
                            optional += "<td>"+user[i].address+"</td>";
                            optional += "<td>"+user[i].role+"</td>";
                            optional += "</tr>";
                        }
                        var dropdownMenu = document.getElementById("tdbody");
                        dropdownMenu.innerHTML = optional;
                        table.show();
                    }
                }
            });
        }
    });

    $("#musictype-btn").click(function () {

        var music = $("#Musictype_field");
        if (music != '') {
            $.ajax({
                url: "info",
                method: "get",
                datatype: 'json',
                data: {
                    'address': '',
                    'music': music.val(),
                    'role': '',
                    'roleAll': ''
                },
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if(result.user != ''){
                        var user =  JSON.parse(result.user);
                        var optional = "";
                        for (var i = 0; i != user.length; ++i) {
                            optional += "<tr>";
                            optional += "<td>"+user[i].login+"</td>";
                            optional += "<td>"+user[i].music_type+"</td>";
                            optional += "<td>"+user[i].address+"</td>";
                            optional += "<td>"+user[i].role+"</td>";
                            optional += "</tr>";
                        }
                        var dropdownMenu = document.getElementById("tdbody");
                        dropdownMenu.innerHTML = optional;
                        table.show();
                    }
                }
            });
        }
    });

    $("#role-all-btn").click(function () {

        var role = $("#Role_field");
        if (address != '') {
            $.ajax({
                url: "info",
                method: "get",
                datatype: 'json',
                data: {
                    'address': '',
                    'music': '',
                    'role': '',
                    'roleAll': role.val()
                },
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if(result.role != ''){
                        var user =  JSON.parse(result.role);
                        var optional = "";
                        for (var i = 0; i != user.length; ++i) {
                            optional += "<tr>";
                            optional += "<td>"+user[i].login+"</td>";
                            optional += "<td>"+user[i].music_type+"</td>";
                            optional += "<td>"+user[i].address+"</td>";
                            optional += "<td>"+user[i].role+"</td>";
                            optional += "</tr>";
                        }
                        var dropdownMenu = document.getElementById("tdbody");
                        dropdownMenu.innerHTML = optional;
                        table.show();
                    }
                }
            });
        }
    });


    function clear() {
        $('input').val('');
    };

});


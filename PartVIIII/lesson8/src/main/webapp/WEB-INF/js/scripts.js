/**
 * Created by dort on 19.12.16.
 */
$(document).ready(function () {
    var oldChosenRow = null;
    var animationTime = 200;
    var messageDisplayTime = 3000;
    var message = $("#message");
    var tableBody = $("tbody");
    var authMessage = $("#auth-message");
    var currentClient = null;

    //send params to create user
    $("#send-create").click(function () {
        var login = $("#create-login-id");
        var password = $("#create-password-id");
        var name = $("#create-name-id");
        var email = $("#create-email-id");
        var role = $("#create-role-id");

        if (Boolean(isValid(login) & isValid(password) & isValid(name)
                & isValid(email))) {
            $.ajax({
                url: "create",
                method: "POST",
                data: {
                    'login': login.val(),
                    'password': password.val(),
                    'name': name.val(),
                    'email': email.val(),
                    'role': role.val()
                },
                dataType: "json",
                success: function (data) {
                    if (data != "") {
                        tableBody.empty();
                        $.each(data.users, function (index, element) {
                            console.log(element);
                            createRow(element);
                        });
                        message.text("User was successfully created");
                        message.removeClass();
                        message.addClass("alert alert-success");
                        $("#creation-block").find("input").val('');
                    } else {
                        message.text("Error occurred. Try again.");
                        message.removeClass();
                        message.addClass("alert alert-danger");
                    }
                }
            });
        } else {
            message.text("Please, fill all inputs");
            message.removeClass();
            message.addClass("alert alert-danger");
        }
        showMessage(message);
    });

    //send params to edit user
    $("#send-edit").click(function () {
        var id = $("#edit-id-id");
        var login = $("#edit-login-id");
        var password = $("#edit-password-id");
        var name = $("#edit-name-id");
        var email = $("#edit-email-id");
        var role = $("#edit-role-id");

        if (Boolean(isValid(id) & isValid(login) & isValid(password) & isValid(name)
                & isValid(email))) {
            $.ajax({
                url: "edit",
                method: "POST",
                data: {
                    'id': id.val(),
                    'login': login.val(),
                    'password': password.val(),
                    'name': name.val(),
                    'email': email.val(),
                    'role': role.val()
                },
                dataType: "json",
                success: function (data) {
                    if (data != "") {
                        tableBody.empty();
                        $.each(data.users, function (index, element) {
                            console.log(element);
                            createRow(element);
                        });
                        if (id.val() == currentClient.id) {
                            currentClient.login = login.val();
                            currentClient.password = password.val();
                            currentClient.name = name.val();
                            currentClient.email = email.val();
                            currentClient.role = role.val();
                            $(".welcome").text(currentClient.name);
                            console.log(currentClient);
                        }
                        $('#return-from-edit').trigger('click').delay(animationTime);
                    }
                }
            });
        } else {
            var msg = $("#edit-message");
            msg.text("Please, fill all inputs");
            msg.removeClass();
            msg.addClass("alert alert-danger");
            showMessage(msg);
        }
    });

    //send params to delete user
    $("#send-delete").click(function () {
        var id = $("#delete-id-id");
        $.ajax({
            url: "delete",
            method: "POST",
            data: {
                'id': id.val()
            },
            dataType: "json",
            success: function (data) {
                if (data != "") {
                    tableBody.empty();
                    $.each(data.users, function (index, element) {
                        console.log(element);
                        createRow(element);
                    });
                    $("#creation-block").find("input").val('');
                    $('#return-from-delete').trigger('click').delay(animationTime);
                }
            }
        });
    });

    // refresh table
    $("#refresh-button").click(function () {
        tableBody.empty();
        $.ajax({
            url: "get",
            method: "GET",
            dataType: "json",
            success: function (data) {
                $.each(data.users, function (index, element) {
                    createRow(element);
                });
            }
        });
    });

    $("#auth-button").click(function () {
        var login = $("#auth-login-id");
        var password = $("#auth-password-id");
        if (Boolean(isValid(login) & isValid(password))) {
            $.ajax({
                url: "signin",
                method: "POST",
                data: {
                    "login": login.val(),
                    "password": password.val()
                },
                success: function (data) {
                    console.log(data);
                    if (data == "error") {
                        authMessage.text("Not valid login-password!");
                        authMessage.removeClass();
                        authMessage.addClass("alert alert-danger");
                        showMessage(authMessage);
                    } else {
                        currentClient = JSON.parse(data);
                        createTableHeader();
                        $('#refresh-button').trigger('click');
                        if (currentClient.role == "user") {
                            hideBlock($("#creation-block-button"));
                            hideBlock($("#edition-block-button"));
                            hideBlock($("#delete-block-button"));
                            $("#edit-role-id").attr('disabled', '');
                        }
                        $(".welcome").text(currentClient.name);
                        hideBlock($("#auth-block"));
                        showBlock($("#table-block"), animationTime);
                        showBlock($("#user-buttons-block"));

                    }
                }
            });
        } else {
            authMessage.text("Please, fill all inputs");
            authMessage.removeClass();
            authMessage.addClass("alert alert-danger");
            showMessage(authMessage);
        }
    });



    function createRow(element) {
        console.log(element);
        var tr = $("<tr></tr>");
        tr.append($("<td></td>").text(element.id));
        tr.append($("<td></td>").text(element.login));
        if (currentClient.role == 'admin') {
            tr.append($("<td></td>").text(element.password));
        }
        tr.append($("<td></td>").text(element.name));
        tr.append($("<td></td>").text(element.email));
        tr.append($("<td></td>").text(element.date));
        tr.append($("<td></td>").text(element.role));
        tableBody.append(tr);
    }

    function createTableHeader() {
        var thead = $("thead");
        var tr = $("<tr></tr>");
        tr.append($("<td></td>").text("ID"));
        tr.append($("<td></td>").text("Login"));
        if (currentClient.role == 'admin') {
            tr.append($("<td></td>").text("Password"));
        }
        tr.append($("<td></td>").text("Name"));
        tr.append($("<td></td>").text("Email"));
        tr.append($("<td></td>").text("Creation Date"));
        tr.append($("<td></td>").text("Role"));
        thead.append(tr);
    }

    function isValid(element) {
        var valid = element.val() != '';
        if (valid) {
            $("label[for='" + element.attr('id') + "']").css("color", "");
        } else {
            $("label[for='" + element.attr('id') + "']").css("color", "red");
        }
        return valid;
    }

    function showMessage(msg) {
        msg.css("visibility", "visible");
        msg.delay(messageDisplayTime).queue(function (next) {
            $(this).css("visibility", "hidden");
            next();
        })
    }

    function showBlock(element, delay) {
        element.delay(delay).fadeIn(animationTime);
    }

    function hideBlock(element) {
        element.fadeOut(animationTime);
    }

    // from table to create block
    $("#creation-block-button").click(function () {
        hideBlock($("#table-block"));
        showBlock($("#creation-block"), animationTime);
    });
    // from create block back to table
    $("#return-from-create").click(function () {
        hideBlock($("#creation-block"));
        showBlock($("#table-block"), animationTime);
        $("#creation-block").find("label").css("color", '');
        $("#creation-block").find("input").val('');
    });

    // from table to edit block
    $("#edition-block-button").click(function () {
        hideBlock($("#table-block"));
        showBlock($("#edition-block"), animationTime);
    });
    // from edit block back to table
    $("#return-from-edit").click(function () {
        $("#edition-block").find("label").css("color", '');
        deactivate(oldChosenRow);
        hideBlock($("#edition-block"));
        showBlock($("#table-block"), animationTime);
    });

    // from table to delete block
    $("#delete-block-button").click(function () {
        hideBlock($("#table-block"));
        showBlock($("#deletion-block"), animationTime);
    });
    // from delete block back to table
    $("#return-from-delete").click(function () {
        deactivate(oldChosenRow);
        hideBlock($("#deletion-block"));
        showBlock($("#table-block"), animationTime);
    });

    // from table to delete block
    $("#edit-me-button").click(function () {
        fillEditForm(currentClient.id, currentClient.login, currentClient.password,
            currentClient.name, currentClient.email, currentClient.role);

        hideBlock($("#table-block"));
        showBlock($("#edition-block"), animationTime);
    });

    $(document).on('click', "tbody tr", function () { // should choose user
        if ($(this).attr("data-clicked") == null) {
            if (oldChosenRow != null) {
                deactivate(oldChosenRow);
            }
            activate(this);
            oldChosenRow = $(this);
        } else {
            deactivate(this);
            oldChosenRow = null;
        }
    });

    function activate(row) {
        $(row).css("background-color", "rgb(78, 186, 218)");
        $(row).css("color", "white");
        $(row).attr("data-clicked", '');
        $("#edition-block-button").removeAttr("disabled");
        $("#delete-block-button").removeAttr("disabled");
        fillForms(row);
    }

    function deactivate(row) {
        $(row).css("background-color", '');
        $(row).css("color", "");
        $(row).removeAttr("data-clicked");
        $("#edition-block-button").attr("disabled", '');
        $("#delete-block-button").attr("disabled", '');
    }

    function fillForms(row) {
        var params = $(row).children();
        var id = $(params[0]).text();
        var login = $(params[1]).text();
        var password = $(params[2]).text();
        var name = $(params[3]).text();
        var email = $(params[4]).text();
        var role = $(params[6]).text();
        fillEditForm(id, login, password, name, email, role);
        fillDeleteForm(id, login, password, name, email, role);
    }

    function fillEditForm(id, login, password, name, email, role) {
        $("#edit-id-id").val(id);
        $("#edit-login-id").val(login);
        $("#edit-password-id").val(password);
        $("#edit-name-id").val(name);
        $("#edit-email-id").val(email);
        $("#edit-role-id").find("option[value='" + role + "']").prop('selected', true);
    }

    function clearEditForm() {
        $("#edit-id-id").val("");
        $("#edit-login-id").val("");
        $("#edit-password-id").val("");
        $("#edit-name-id").val("");
        $("#edit-email-id").val("");
    }

    function fillDeleteForm(id, login, password, name, email, role) {
        $("#delete-id-id").attr("value", id);
        $("#delete-login-id").attr("value", login);
        $("#delete-password-id").attr("value", password);
        $("#delete-name-id").attr("value", name);
        $("#delete-email-id").attr("value", email);
        $("#delete-role-id").find("option[value='" + role + "']").prop('selected', true);
    }

});
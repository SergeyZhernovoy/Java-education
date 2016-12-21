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
                    alert(111);
                    if(Boolean(result.isValid)){
                        location.href = "/crud/pages/CrudView.html";
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


});



/**
 * Created by dort on 02.01.17.
 */

function viewItems() {

    var all = false;

    if($("#checkDone").prop('checked')){
        var all = true;
    }

    $.ajax({
        url: "list",
        method: "get",
        datatype: 'json',
        data: {
            'done': all
        },
        complete: function (data) {
            var result = JSON.parse(data.responseText);
            if(result.tasks != ''){
                var next =  JSON.parse(result.tasks);
                var optional = "";
                for (var i = 0; i != next.length; ++i) {
                    optional += "<tr>";
                    optional += "<td>"+next[i].descr+"</td>";
                    optional += "<td>"+next[i].createDate+"</td>";
                    optional += "<td>"+next[i].done+"</td>";
                    optional += "</tr>";
                }
                var table = document.getElementById("tbody");
                table.innerHTML = optional;
            }
        }
    });

}


function clear() {
    $('input').val('');
    $("#done").prop('checked',false);
};

$(document).ready(function () {

    viewItems();

    $("#create").click(function () {
        var descr = $("#descr");
        var done = $("#done");

        if(descr != ''){
            $.ajax({
                url: "create",
                method: "post",
                data: {
                    'descr': descr.val(),
                    'done': done.val()},
                complete: function (data) {
                    var result = JSON.parse(data.responseText);
                    if (Boolean(result.successCreate)) {
                        alert("Success create todo task");
                        clear();
                        viewItems();
                    }
                    else {
                        alert("Bad try create task. Try again");
                    }
                }
            });
        }


    });

    $("#checkDone").click(function () {
        location.reload();
    });

})

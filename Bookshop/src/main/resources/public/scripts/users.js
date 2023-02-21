$(document).ready(function() {
    if (localStorage.getItem('status') === 'success') {
       $("#validation-success").fadeIn(3000).fadeOut(3000);
        localStorage.setItem('status', '');
    };
    $.getJSON("/user", function(data, status) {
        $.each(data, function(i, item) {
            $tdForCheckbox = $('<td>').append(
                $('<input>', {
                    class: "w3-check",
                    type: "checkbox"
                }));
            var $tr = $('<tr class="users-row users-row-' + item.userId + '">').append(
                $tdForCheckbox,
                $('<td id="userId">').text(item.userId),
                $('<td id="userName">').text(item.userName),
                $('<td id="login">').text(item.login),
                $('<td id="email">').text(item.email),
                $('<td id="address">').text(item.address)
            ).appendTo('#users');
        });
    });
});
//    $("#add-story").click(function() {
//        var body = validateForm();
//
//        if (body) {
//            return $.ajax({
//                type: 'POST',
//                url: '/api/story',
//                data: JSON.stringify(body),
//                success: function(data) {
//                    localStorage.setItem('status', 'success');
//                    location.reload();
//
//                },
//                error: function(jqXHR, textStatus, errorThrown) {
//                    showError(jqXHR.responseJSON.message, jqXHR.responseText);
//                },
//                contentType: "application/json",
//                dataType: 'json'
//            });
//        }
//    });
//
//    $('#delete-story').on('click', function() {
//        var stories = getSelectedStories();
//
//        $.ajax({
//                type: 'DELETE',
//                url: '/api/story',
//                data: JSON.stringify(stories),
//                success: function(data) {
//                    $("#validation-success").fadeIn(3000).fadeOut(3000);
//                    $.each(stories, function(i, row) {
//                        var rowToDelete = $(".story-row-" + row.jiraId);
//                        rowToDelete.remove();
//                    });
//                },
//                error: function(jqXHR, textStatus, errorThrown) {
//                    showError(jqXHR.responseJSON.message, jqXHR.responseText);
//                },
//                contentType: "application/json",
//                dataType: 'json'
//            });
//    });
//});
//
//function validateForm() {
//    var body = {
//        jiraId: $("#jiraId-input").val(),
//        summary: $("#summary-input").val()
//    };
//    if (body.jiraId == "" || body.summary == "") {
//        showError('Please fill all fields', 'All fields must pe populated');
//        return false;
//    }
//    return body;
//}
//
//function getSelectedStories() {
//    var selected = [];
//    $("tr.story-row").each(function() {
//        $this = $(this);
//        var isSelected = $this.find(".w3-check").is(':checked');
//        if (isSelected) {
//            var body = {
//                jiraId: $this.find("#jiraId").text(),
//                summary: $this.find("#summary").text()
//             };
//            selected.push(body);
//        }
//    });
//    return selected;
//}
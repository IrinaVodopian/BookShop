$(document).ready(function() {
    if (localStorage.getItem('status') === 'success') {
       $("#validation-success").fadeIn(3000).fadeOut(3000);
        localStorage.setItem('status', '');
    };
    $.getJSON("/product", function(data, status) {
        $.each(data, function(i, item) {
       var $div = $('<div style="width: 18rem;" class="text-dark card ' + item.productId + '">').append(
                $('<div class="card-body">'),
                $('<h3 id="product-title">').text('Title: ' + item.productName),
                $('<p id="description">').text('Description: ' + item.description),
                $('<p id="author">').text('Author: ' + item.author),
                $('<p id="price">').text('Price: ' + item.price),
                $('<img class="card-img-bottom" src="marguerite.jpg" alt="Product image">'),
                $('<button type="button" class="btn btn-success"  data-bs-toggle="modal" data-bs-target="#exampleModal">').text('Edit'),
                $('<button type="button" class="btn btn-danger">').text('Delete')
            ).appendTo('#productCard');
        });
    });
    });

//    $('#delete-user').on('click', function() {
//            var users = getSelectedUsers();
//            $.ajax({
//                    type: 'DELETE',
//                    url: '/user',
//                    data: JSON.stringify(users),
//                    success: function(data) {
//                        $("#validation-success").fadeIn(3000).fadeOut(3000);
//                        $.each(stories, function(i, row) {
//                            var rowToDelete = $(".users-row-" + row.userId);
//                            rowToDelete.remove();
//                        });
//                    },
//                    contentType: "application/json",
//                    dataType: 'json'
//                });
//        });
//    });

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
////
//function getSelectedUsers() {
//    var selected = [];
//    $("tr.users-row").each(function() {
//        $this = $(this);
//        var isSelected = $this.find(".w3-check").is(':checked');
//        if (isSelected) {
//            selected.push($this.find("#userId").text());
//        }
//    });
//    console.log(selected)
//    return selected;
//}
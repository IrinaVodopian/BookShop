$(document).ready(function() {
    if (localStorage.getItem('status') === 'success') {
       $("#validation-success").fadeIn(3000).fadeOut(3000);
        localStorage.setItem('status', '');
    };
    $.getJSON("/booking", function(data, status) {
        $.each(data, function(i, item) {
       var $div = $('<div style="width: 18rem;" class="text-dark card ' + item.productId + '">').append(
                $('<div class="card-body">'),
                $('<h3 id="product-title">').text('Title: ' + item.product.productName),
                $('<p id="date">').text('Date: ' + item.date),
                $('<p id="time">').text('Preferred time: ' + item.time),
                $('<p id="address">').text('Delivery address: ' + item.deliveryAddress),
                $('<p id="status">').text('Status: ' + item.status),
                $('<img class="card-img-bottom" src="marguerite.jpg" alt="Product image">'),
                $('<button type="button" class="btn btn-success id = "approve-booking"">').text('Approve'),
                $('<button type="button" class="btn btn-danger" id = "reject-booking">').text('Reject'),
                $('<button type="button" class="btn btn-primary" id = "close-booking">').text('Close')
            ).appendTo('#bookingCard');
        });
    });
    });

//    $('#delete-booking').on('click', function() {
////            var users = getSelectedUsers();
//            $.ajax({
//                    type: 'DELETE',
//                    url: '/booking/{item.}',
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

    $("#add-story").click(function() {
        var body = validateForm();

        if (body) {
            return $.ajax({
                type: 'POST',
                url: '/api/story',
                data: JSON.stringify(body),
                success: function(data) {
                    localStorage.setItem('status', 'success');
                    location.reload();

                },
                error: function(jqXHR, textStatus, errorThrown) {
                    showError(jqXHR.responseJSON.message, jqXHR.responseText);
                },
                contentType: "application/json",
                dataType: 'json'
            });
        }
    });
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
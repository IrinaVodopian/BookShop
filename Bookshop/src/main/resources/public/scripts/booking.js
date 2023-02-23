$(document).ready(function() {
    if (localStorage.getItem('status') === 'success') {
       $("#validation-success").fadeIn(3000).fadeOut(3000);
        localStorage.setItem('status', '');
    };
    localStorage.setItem('userLogin', 'login1');
    console.log(localStorage.getItem('userLogin'));
    $.getJSON("/booking", function(data, status) {
        $.each(data, function(i, item) {
       var $div = $('<div style="width: 18rem;" class="text-dark card ' + item.product.productId + '">').append(
                $('<div class="card-body">'),
                $('<h3 id="product-title">').text('Title: ' + item.product.productName),
                $('<p id="date">').text('Date: ' + item.date),
                $('<p id="time">').text('Preferred time: ' + item.time),
                $('<p id="address">').text('Delivery address: ' + item.deliveryAddress),
                $('<p id="status">').text('Status: ' + item.status),
                $('<img class="card-img-bottom" src="marguerite.jpg" alt="Product image">'),
                $('<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">').text('Edit'),
                $('<button type="button" class="btn btn-danger" onclick="cancelBooking($(this))" id=' + item.product.productId + '>').text('Cancel')
            ).appendTo('#bookingCard');
        });
    });
    });

function cancelBooking(object){
    var id = object.attr('id');
    $.ajax({
                        type: 'DELETE',
                        url: '/booking/' + id,
                        success: function(data) {
                            $("#validation-success").fadeIn(3000).fadeOut(3000);
                            $.each(stories, function(i, row) {
                                var rowToDelete = $(".users-row-" + row.userId);
                                rowToDelete.remove();
                            });
                        },
                        contentType: "application/json",
                        dataType: 'json'
                    });
    alert("The booking has been deleted!");
}
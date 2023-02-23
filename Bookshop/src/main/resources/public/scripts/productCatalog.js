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
                $('<button type="button" class="btn btn-primary" onclick="bookProduct($(this))" id=' + item.productId + '>').text('Book')
            ).appendTo('#productCard');
        });
    });
    });

//CHECK LOCAL STORAGE AND USERS
function bookProduct(object){
    var productId = object.attr('id');
    var body = {
                userId: localStorage.getItem('userId'),
                productId: productId,
                quantity: 1
            };
    createBooking(body);
}

function createBooking(body){
    return $.ajax({
                    type: 'POST',
                    url: '/booking/createById',
                    data: JSON.stringify(body),
                    success: function(data) {
                        alert('Booking has been created!');
                        localStorage.setItem('status', 'success');
                        location.reload();
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
}
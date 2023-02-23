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

//CHECK LOCAL STORAGE AND USERS RETURNS 500
function bookProduct(object){
    var productId = object.attr('id');
    localStorage.setItem('userId', '1');
    var product = getProduct(productId);
    console.log(product);
    var user = getUser();
    var body = {
                user: user,
                product: product,
                deliveryAddress: user.address,
                date: '1989-09-29',
                time: '18:18:18',
                quantity: 1
            };
    createBooking(body);
}

function getProduct(productId){
    return $.ajax({
                    type: 'GET',
                    url: '/product/' + productId,
                    dataType: "json",
                    success: function(data) {
                },

                });
    }

function getUser(){
    return $.ajax({
                    type: 'GET',
                    url: '/user/' + localStorage.getItem('userId'),
                    dataType: "json",
                    success: function(data) {

                }
                });
}


function createBooking(body){
    return $.ajax({
                    type: 'POST',
                    url: '/booking',
                    data: JSON.stringify(body),
                    success: function(data) {
                        localStorage.setItem('status', 'success');
                        location.reload();
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
}
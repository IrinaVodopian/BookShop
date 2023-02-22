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
                $('<button type="button" class="btn btn-primary" onclick="bookProduct()" id=' + item.productId + '">').text('Book')
            ).appendTo('#productCard');
        });
    });
    });

function bookProduct(){
    var id = $(this).attr('id');
    var booking = $.getJSON("/product/" + id, function(data, status);
    product.set
    if (product) {
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


    alert("The product has been booked!");
}
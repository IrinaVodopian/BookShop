$(document).ready(function() {
    if (localStorage.getItem('status') === 'success') {
       $("#validation-success").fadeIn(3000).fadeOut(3000);
        localStorage.setItem('status', '');
    }
    $.getJSON("/product", function(data, status) {
        $.each(data, function(i, item) {
       var $div = $('<div style="width: 18rem;" class="text-dark card ' + item.productId + '">').append(
                $('<h3 id="product-title">').text('Title: ' + item.productName),
                $('<p id="description">').text('Description: ' + item.description),
                $('<p id="author">').text('Author: ' + item.author),
                $('<p id="price">').text('Price: ' + item.price),
                $('<img class="card-img-bottom" src="marguerite.jpg" alt="Product image">'),
                $('<button type="button" class="btn btn-success"  data-bs-toggle="modal" data-bs-target="#exampleModal">').text('Edit'),
                $('<button type="button" class="btn btn-danger" onclick = "deleteProduct($(this))" id=' + item.productId + '>').text('Delete')
            ).appendTo('#productCard');
        });
    });
    });

//405 CHECK
function deleteProduct(object){
    var productId = object.attr('id');
    $.ajax({
                        type: 'DELETE',
                        url: '/product/' + productId,
                        success: function(data) {
                            $("#validation-success").fadeIn(3000).fadeOut(3000);
                            alert("The product has been deleted!");
                        },
                        contentType: "application/json",
                        dataType: 'json'
                    });

}

function saveProduct(){
    var body = validateForm();
    if (body) { sendRequest(body);}
    alert("The product has been saved!");
}

function validateForm() {
        var body = {
            productId: $("#inputProductIdModal").val(),
            productName: $("#inputProductNameModal").val(),
            description: $("#inputDescription").val(),
            author: $("#inputAuthorModal").val(),
            price: $("#inputPriceModal").val(),
            imagePath: $("#inputImagePath").val()
        };
        return body;
}

function sendRequest(body){
    return $.ajax({
                    type: 'POST',
                    url: '/product',
                    data: JSON.stringify(body),
                    success: function(data) {
                        localStorage.setItem('status', 'success');
                        location.reload();
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
}
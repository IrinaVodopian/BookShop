$(document).ready(function() {
    if (localStorage.getItem('status') === 'success') {
       $("#validation-success").fadeIn(3000).fadeOut(3000);
        localStorage.setItem('status', '');
    }
    $.getJSON("/booking", function(data, status) {
        $.each(data, function(i, item) {
       var $div = $('<div style="width: 18rem;" class="text-dark card card' + item.product.productId + '">').append(
                $('<div class="card-body">'),
                $('<h3 id="product-title">').text('Title: ' + item.product.productName),
                $('<p id="date">').text('Date: ' + item.date),
                $('<p id="time">').text('Preferred time: ' + item.time),
                $('<p id="address">').text('Delivery address: ' + item.deliveryAddress),
                $('<p id="status">').text('Status: ' + item.status),
                $('<img class="card-img-bottom" src="marguerite.jpg" alt="Product image">'),
                $('<button type="button" class="btn btn-success" status="APPROVED" onclick="setStatus($(this))" id=' + item.product.productId + '>').text('Approve'),
                $('<button type="button" class="btn btn-danger" status="REJECTED" onclick="setStatus($(this))" id=' + item.product.productId + '>').text('Reject'),
                $('<button type="button" class="btn btn-primary" status="COMPLETED" onclick="setStatus($(this))" id=' + item.product.productId + '>').text('Close')
            ).appendTo('#bookingCard');
        });
    });
    });

function setStatus(object, status){
    alert("Status has been changed!");
    var id = object.attr('id');
    var status = object.attr('status');
    return $.ajax({
                    type: 'PUT',
                    url: '/booking/status/' + id,
                    data: JSON.stringify(status),
                    success: function(data) {
                        localStorage.setItem('status', 'success');
                        location.reload();
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
}

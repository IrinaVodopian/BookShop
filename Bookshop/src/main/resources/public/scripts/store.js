$(document).ready(function() {
    if (localStorage.getItem('status') === 'success') {
       $("#validation-success").fadeIn(3000).fadeOut(3000);
        localStorage.setItem('status', '');
    };
    $.getJSON("/storeItem", function(data, status) {
        $.each(data, function(i, item) {
            $tdForCheckbox = $('<td>').append(
                $('<input>', {
                    class: "w3-check",
                    type: "checkbox"
                }));
            var $tr = $('<tr class="store-row store-row-' + item.storeId + '">').append(
                $tdForCheckbox,
                $('<td id="productId">').text(item.product.productId),
                $('<td id="productName">').text(item.product.productName),
                $('<td id="available">').text(item.availableQty),
                $('<td id="booked">').text(item.bookedQty),
                $('<td id="sold">').text(item.soldQty)
            ).appendTo('#store');
        });
    });

    $('#search-item').on('click', function() {
                        clearTable();
                        var id = document.getElementById('inputProductId').value;
                        $.getJSON("/storeItem/" + id, function(data, status) {
                                    $tdForCheckbox = $('<td>').append(
                                                    $('<input>', {
                                                        class: "w3-check",
                                                        type: "checkbox"
                                                    }));
                                                var $tr = $('<tr class="store-row store-row-' + data.storeId + '">').append(
                                                    $tdForCheckbox,
                                                    $('<td id="productId">').text(data.product.productId),
                                                    $('<td id="productName">').text(data.product.productName),
                                                    $('<td id="available">').text(data.availableQty),
                                                    $('<td id="booked">').text(data.bookedQty),
                                                    $('<td id="sold">').text(data.soldQty)
                                                ).appendTo('#store');
                            });
                });

    $('#delete-product').on('click', function() {
        var stores = getSelectedProducts();
        $.ajax({
                type: 'DELETE',
                url: '/storeItem',
                data: JSON.stringify(stores),
                success: function(data) {
                    $("#validation-success").fadeIn(3000).fadeOut(3000);
                     location.reload();
                },
                contentType: "application/json",
                dataType: 'json'
            });
            alert("The items were deleted.");
    });
});

function getSelectedProducts() {
    var selected = [];
    $("tr.store-row").each(function() {
        $this = $(this);
        var isSelected = $this.find(".w3-check").is(':checked');
        if (isSelected) {
            selected.push($this.find("#productId").text());
        }
    });
    return selected;
}

function saveItem(){
    var productId = $("#inputProductIdModal").val();
    var body = validateForm();
    if (body) { sendRequest(productId, body);}
}

function validateForm() {
        var body = {
            storeId: $("#inputStoreIdModal").val(),
            availableQty: $("#inputAvailable").val(),
            bookedQty: $("#inputBooked").val(),
            soldQty: $("#inputDelivered").val()
        };
        if (body.storeId == "" || body.availableQty == "" || body.bookedQty == "" || body.soldQty == "") {
                        alert('Please fill all fields', 'All fields must pe populated');
                        return false;
                    }
        return body;
}

function sendRequest(productId, body){
    return $.ajax({
                    type: 'POST',
                    url: '/storeItem/' + productId,
                    data: JSON.stringify(body),
                    success: function(data) {
                        localStorage.setItem('status', 'success');
                        alert("The item has been saved!");
                        location.reload();
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
}

function clearTable(){
    $("tr.store-row").each(function() {
            $(this).remove();
        });
}
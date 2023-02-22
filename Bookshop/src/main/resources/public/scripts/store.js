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

    $('#delete-product').on('click', function() {
        var stores = getSelectedProducts();
        $.ajax({
                type: 'DELETE',
                url: '/storeItem',
                data: JSON.stringify(stores),
                success: function(data) {
                    $("#validation-success").fadeIn(3000).fadeOut(3000);
//                    $.each(stories, function(i, row) {
//                        var rowToDelete = $(".store-row-" + row.storeId);
//                        rowToDelete.remove();
//                    });
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
    console.log(selected);
    return selected;
}

function saveItem(){
    var body = validateForm();
    if (body) { sendRequest(body);}
    alert("The item has been saved!");
}

function validateForm() {
        var productId = $("#inputProductIdModal").val();
        var productModal = getProduct(productId);
        console.log(productModal);
        var body = {
            storeId: $("#inputStoreIdModal").val(),
            product: productModal,
            availableQty: $("#inputAvailable").val(),
            author: $("#inputBooked").val(),
            price: $("#inputDelivered").val()
        };
        console.log(body);
        return body;
}

function sendRequest(body){
    return $.ajax({
                    type: 'POST',
                    url: '/storeItem',
                    data: JSON.stringify(body),
                    success: function(data) {
                        localStorage.setItem('status', 'success');
                        location.reload();
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
}

function getProduct(id){
    return $.ajax({
                    type: 'GET',
                    url: '/product/' + id,
                    success: function(data) {
                        localStorage.setItem('status', 'success');
                        location.reload();
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
}
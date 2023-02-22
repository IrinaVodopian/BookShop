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
    $('#delete-product').on('click', function() {
    console.log("clicked")
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
    });
});
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
//
function getSelectedProducts() {
    var selected = [];
    $("tr.store-row").each(function() {
        $this = $(this);
        var isSelected = $this.find(".w3-check").is(':checked');
        if (isSelected) {
//            var body = {
//                $this.find("#productId").text()
//             };
            selected.push($this.find("#productId").text());
        }
    });
    console.log(selected);
    return selected;
}
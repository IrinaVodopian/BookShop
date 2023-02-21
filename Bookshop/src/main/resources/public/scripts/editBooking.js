function validateForm() {
        var body = {
            product: 1,
            user: 1,
            date: $("#inputDate").val(),
            time: $("#inputTime").val(),
            address: $("#inputAddress").val()
        };
        return body;
}

function sendRequest(id){
    return $.ajax({
                    type: 'PUT',
                    url: '/booking/{id}',
                    data: JSON.stringify(body),
                    success: function(data) {
                        localStorage.setItem('status', 'success');
                        location.reload();
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
}

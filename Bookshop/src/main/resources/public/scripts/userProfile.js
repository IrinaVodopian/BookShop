function validateForm() {
        var body = {
            userName: $("#inputName").val(),
            email: $("#inputEmail").val(),
            phone: $("#inputPhone").val(),
            address: $("#inputAddress").val(),
            login: $("#inputLogin").val(),
            password: $("#inputPassword").val()
        };
        return body;
}

function sendRequest(body){
    return $.ajax({
                    type: 'POST',
                    url: '/user',
                    data: JSON.stringify(body),
                    success: function(data) {
                        localStorage.setItem('status', 'success');
                        location.reload();
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
}

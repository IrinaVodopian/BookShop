$(document).ready(function() {
    if (localStorage.getItem('status') === 'success') {
       $("#validation-success").fadeIn(3000).fadeOut(3000);
        localStorage.setItem('status', '');
    };
    $("#create-user").click(function() {
            var body = validateForm();
            if (body) { sendRequest(body); }
        });
    });

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
                        alert("The user has been created! You can login now.");
                        location.href = "../pages/login.html";
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
}


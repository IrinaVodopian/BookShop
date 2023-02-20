//$(document).ready(function(){
//    $("#create-user").click(function() {
//            console.log("smth")
//            var body = validateForm();
//            if (body) {
//                return $.ajax({
//                    type: 'POST',
//                    url: '/user',
//                    data: JSON.stringify(body),
//                    success: function(data) {
//                        localStorage.setItem('status', 'success');
//                        location.reload();
//                    },
//                    error: function(jqXHR, textStatus, errorThrown) {
//                        showError(jqXHR.responseJSON.message, jqXHR.responseText);
//                    },
//                    contentType: "application/json",
//                    dataType: 'json'
//                });
//            }
//        });
//    });
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

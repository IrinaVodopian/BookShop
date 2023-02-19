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
            inputName: $("#inputName").val(),
            inputEmail: $("#inputEmail").val(),
            inputPhone: $("#inputPhone").val(),
            inputAddress: $("#inputAddress").val(),
            inputLogin: $("#inputLogin").val(),
            inputPassword: $("#inputPassword").val()
        };
        return body;

}
